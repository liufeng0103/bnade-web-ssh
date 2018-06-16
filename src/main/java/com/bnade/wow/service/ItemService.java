package com.bnade.wow.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.bnade.wow.dto.ItemDTO;
import com.bnade.wow.entity.Item;
import com.bnade.wow.entity.Pet;
import com.bnade.wow.repository.ItemBonusRepository;
import com.bnade.wow.repository.ItemRepository;
import com.bnade.wow.repository.ItemSearchStatisticRepository;
import com.bnade.wow.repository.PetRepository;
import com.bnade.wow.repository.PetStatsRepository;
import com.bnade.wow.utils.HttpUtils;

/**
 * 物品service
 * Created by liufeng0103@163.com on 2017/6/12.
 */
@Service
public class ItemService {

    private static Logger logger = LoggerFactory.getLogger(ItemService.class);

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PetStatsRepository petStatsRepository;
    @Autowired
    private ItemBonusRepository itemBonusRepository;
    @Autowired
    private ItemSearchStatisticRepository itemSearchStatisticRepository;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public List<Item> search(String name) {
        return null;
    }

    /**
     * 查询所有包含查询值的物品名
     * @param name 查询名
     * @param limit 返回的条数
     * @return 物品名列表
     */
    public List<String> searchNamesByNameContaining(String name, Integer limit) {
        return itemRepository.searchNamesByNameContaining(name, limit);
    }

    /**
     * 通过物品名查询物品和宠物
     * @param name 物品名
     * @return 物品列表
     */
    public List<ItemDTO> findByName(String name) {
        List<ItemDTO> itemDTOs = new ArrayList<>();
        List<Item> items = itemRepository.findByName(name);
        for (Item item : items) {
            // TODO 不是所有物品都有bonus list，这里可以优化
        	ItemDTO itemDTO = new ItemDTO();
        	BeanUtils.copyProperties(item, itemDTO);
        	itemDTO.setBonusLists(itemBonusRepository.findBonusListsByItemId(item.getId()));
        	itemDTOs.add(itemDTO);
        }
        if (items.size() == 0) {
        	List<Pet> pets = petRepository.findByName(name);
        	for (Pet pet : pets) {
        		ItemDTO itemDTO = new ItemDTO();
        		itemDTO.setId(Item.PET_CAGE_ID);
        		itemDTO.setName(pet.getName());
        		itemDTO.setIcon(pet.getIcon());
        		itemDTO.setLevel(25);
        		itemDTO.setPetSpeciesId(pet.getId());
        		itemDTO.setPetStatsList(petStatsRepository.findBySpeciesId(pet.getId()));
        		itemDTOs.add(itemDTO);
        	}
        }
        return itemDTOs;
    }

    /**
     * 通过id查询物品
     * @param itemId 物品id
     * @return 物品信息
     */
    @Cacheable(cacheNames = "items", keyGenerator="customKeyGenerator")
    public Item findById(Integer itemId) {
        Item item = itemRepository.findOne(itemId);
        if (item != null) {
            if (item.getItemClass() == 2 || item.getItemClass() == 3 || item.getItemClass() == 4) { // 过滤，减少数据库查询
                item.setBonusLists(itemBonusRepository.findBonusListsByItemId(item.getId()));
            } else {
                item.setBonusLists(new ArrayList<>(0));
            }
        }
        return item;
    }

    /**
     * 查询物品的提示信息
     * 信息来源战网如 https://www.battlenet.com.cn/wow/zh/item/147038/tooltip?bl=1472
     * 如果可以找到则缓存到redis
     *
     * @param id 物品id
     * @param bonusList 物品奖励
     * @return 物品提示信息，格式为html片段
     */
    public String getTooltipByIdAndBonusList(Integer id, String bonusList) {
        String key = "tooltip" + id + "-" + bonusList;
        String result = stringRedisTemplate.opsForValue().get(key);
        if (null == result) {
            String url = "https://www.battlenet.com.cn/wow/zh/item/" + id + "/tooltip?bl=" + bonusList;
            try {
                String tooltip = HttpUtils.get(url);
                tooltip = tooltip
                        .replaceAll("\r|\n", "") // 去掉回车换行
                        .replaceAll("https://render-cn.worldofwarcraft.com", "http://content.battlenet.com.cn/wow")
                        .replaceAll("href=\"[^\"]*\"", "href=\"\""); // 替换掉html中的超链接的地址
                result = tooltip;
                int timeout = 60 * 12; // 缓存多久过期
                stringRedisTemplate.opsForValue().set(key, tooltip, timeout, TimeUnit.MINUTES);
            } catch (FileNotFoundException e) {
                // 404 物品信息找不到
                logger.info("获取不到物品id: {} bonusList: {} 信息", id, bonusList);
            }  catch (SocketTimeoutException e) {
                // 查询超时
                logger.info("查询物品超时id: {} bonusList: {}", id, bonusList);
            } catch (IOException e) {
                logger.info("通过http获取物品id: {} bonusList: {} 信息出错", id, bonusList,e);
            }
        }
        return result;
    }

}
