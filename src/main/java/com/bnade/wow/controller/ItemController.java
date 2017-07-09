package com.bnade.wow.controller;

import com.bnade.wow.entity.Item;
import com.bnade.wow.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 物品查询controller
 * Created by liufeng0103@163.com on 2017/6/27.
 */
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 通过物品名查询物品
     * @param name 物品名
     * @return 物品列表
     */
    @GetMapping
    public List<Item> findByName(@RequestParam("name") String name) {
        return itemService.findByName(name);
    }

    /**
     * 查询所有包含查询值的物品名
     * @param search 查询名
     * @param limit 返回的条数,默认返回10条
     * @return 物品名列表
     */
    @GetMapping("/names")
    public List<String> searchNames(
            @RequestParam(value = "search") String search,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        return itemService.searchNamesByNameContaining(search, limit);
    }

}
