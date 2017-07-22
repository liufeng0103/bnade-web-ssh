package com.bnade.wow.service;

import com.bnade.wow.entity.Item;
import com.bnade.wow.repository.ItemBonusRepository;
import com.bnade.wow.repository.ItemRepository;
import com.bnade.wow.repository.ItemSearchStatisticRepository;
import com.bnade.wow.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
     * 通过物品名查询物品
     * @param name 物品名
     * @return 物品列表
     */
    public List<Item> findByName(String name) {
        List<Item> items = itemRepository.findByName(name);
        for (Item item : items) {
            // TODO 不是所有物品都有bonus list，这里可以优化
            item.setBonusLists(itemBonusRepository.findBonusListsByItemId(item.getId()));
        }
        return items;
    }

    /**
     * 通过id查询物品
     * @param id 物品id
     * @return 物品信息
     */
    public Item findById(Integer id) {
        Item item = itemRepository.findOne(id);
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
        int timeout = 60; // 60分钟后过期
        String key = "tooltip" + id + "-" + bonusList;
        String result = stringRedisTemplate.opsForValue().get(key);
        if (null == result) {
            String url = "https://www.battlenet.com.cn/wow/zh/item/" + id + "/tooltip?bl=" + bonusList;
            try {
                String tooltip = HttpUtils.get(url);
                tooltip = tooltip
                        .replaceAll("\r|\n", "") // 去掉回车换行
                        .replaceAll("href=\"[^\"]*\"", "href=\"\""); // 替换掉html中的超链接的地址
                result = tooltip;
                stringRedisTemplate.opsForValue().set(key, tooltip);
                stringRedisTemplate.expire(key, timeout, TimeUnit.MINUTES);
            } catch (FileNotFoundException e) {
                // 404 物品信息找不到
                logger.info("获取不到物品id: {} bonusList: {} 信息", id, bonusList);
            } catch (IOException e) {
                logger.info("通过http获取物品id: {} bonusList: {} 信息出错", id, bonusList,e);
            }
        }
        return result;
    }

}
