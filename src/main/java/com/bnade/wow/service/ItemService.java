package com.bnade.wow.service;

import com.bnade.wow.entity.Auction;
import com.bnade.wow.entity.Item;
import com.bnade.wow.entity.ItemBonus;
import com.bnade.wow.repository.AuctionRepository;
import com.bnade.wow.repository.ItemBonusRepository;
import com.bnade.wow.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
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

}
