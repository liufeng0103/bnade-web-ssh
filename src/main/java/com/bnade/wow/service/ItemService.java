package com.bnade.wow.service;

import com.bnade.wow.entity.Item;
import com.bnade.wow.repository.ItemBonusRepository;
import com.bnade.wow.repository.ItemRepository;
import com.bnade.wow.repository.ItemSearchStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 物品service
 * Created by liufeng0103@163.com on 2017/6/12.
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemBonusRepository itemBonusRepository;
    @Autowired
    private ItemSearchStatisticRepository itemSearchStatisticRepository;

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

}
