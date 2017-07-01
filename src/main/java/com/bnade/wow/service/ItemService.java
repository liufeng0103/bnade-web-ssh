package com.bnade.wow.service;

import com.bnade.wow.entity.Item;
import com.bnade.wow.entity.ItemBonus;
import com.bnade.wow.repository.ItemBonusRepository;
import com.bnade.wow.repository.ItemRepository;
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

    public List<Item> search(String name) {
        List<Item> items = itemRepository.searchByName(name);
        for (Item item : items) {
            List<String> bonusList = new ArrayList<>();
            item.setBonusList(bonusList);
            List<ItemBonus> itemBonuses = itemBonusRepository.findByItemId(item.getId());
            for (ItemBonus itemBonus : itemBonuses) {
                bonusList.add(itemBonus.getBonusList());
            }
        }
        return items;
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
}
