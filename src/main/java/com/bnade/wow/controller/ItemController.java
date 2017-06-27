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
     * 通过参数search的值查询所有包含该值的物品
     * API GET /items?search=xxx
     * @param name 物品名
     * @return 物品列表
     */
    @GetMapping
    public List<Item> search(@RequestParam("search") String name) {
        return itemService.search(name);
    }
}
