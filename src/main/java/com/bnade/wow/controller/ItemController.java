package com.bnade.wow.controller;

import com.bnade.wow.dto.ItemSearchStatisticDTO;
import com.bnade.wow.entity.Item;
import com.bnade.wow.entity.ItemSearchStatistic;
import com.bnade.wow.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * GET /items?name={name}
     * @param name 物品名
     * @return 物品列表
     */
    @GetMapping
    public List<Item> findByName(@RequestParam("name") String name) {
        return itemService.findByName(name);
    }

    /**
     * 查询所有包含查询值的物品名
     * GET /items/names?search={search}&limit={limit}
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

    /**
     * 通过物品id查询
     * GET /items/{id}
     * @param id 物品id
     * @return 物品信息
     */
    @GetMapping("/{id}")
    public Item findById(@PathVariable("id") Integer id) {
        return itemService.findById(id);
    }

    /**
     * 搜索统计
     * 目前只实现返回每日，每周，每月搜索最多的10个物品
     *
     * @return 统计列表
     */
    @GetMapping("/search-statistics")
    public List<ItemSearchStatisticDTO> findSearchStatistics() {
        return itemService.findSearchStatistics();
    }

}
