package com.bnade.wow.controller;

import com.bnade.wow.dto.ItemSearchStatisticDTO;
import com.bnade.wow.dto.ItemStatisticDTO;
import com.bnade.wow.entity.Item;
import com.bnade.wow.entity.ItemStatistic;
import com.bnade.wow.service.ItemService;
import com.bnade.wow.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物品查询controller
 *
 * Created by liufeng0103@163.com on 2017/6/27.
 */
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private StatisticService statisticService;

    /**
     * 通过物品名查询物品
     * GET /items?name={name}
     *
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
     *
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
     *
     * @param id 物品id
     * @return Item 物品信息
     */
    @GetMapping("/{id}")
    public Item findById(@PathVariable("id") Integer id) {
        return itemService.findById(id);
    }

    /**
     * 获取物品提示信息
     *
     * @param id 物品id
     * @param bonusList 物品奖励
     * @return 物品提示，格式为html片段
     */
    @GetMapping(value = {"/{id}/tooltips", "/{id}/tooltip"})
    public String getTooltip(@PathVariable("id") Integer id,
                              @RequestParam(value = "bonusList", defaultValue = "") String bonusList) {
        return itemService.getTooltipByIdAndBonusList(id, bonusList);
    }

    /**
     * 搜索统计
     *
     * @return List<ItemSearchStatisticDTO> 统计列表
     */
    @GetMapping("/search-statistics")
    public List<ItemSearchStatisticDTO> findSearchStatistics(@RequestParam(value = "type", defaultValue = "0") Integer type,
                                                             @RequestParam(value = "page", defaultValue = "0") Integer page) {
        // 获取一周内的搜索排行
        if (ItemSearchStatisticDTO.WEEKLY == type) {
            int size = 50;
            return statisticService.findWeeklyItemSearchStatisticsByType(page, size);
        } else {
            // 目前只实现返回每日，每周，每月搜索最多的10个物品
            return statisticService.findItemSearchStatistics();
        }
    }

    /**
     * 物品统计
     * url例子/statistics?page=10&size=50&sort=marketPrice,desc
     *
     * @param pageable size默认50，sort默认marketPrice倒序
     * @return
     */
    @GetMapping("/statistics")
    public List<ItemStatisticDTO> findStatistics(@PageableDefault(value = 50, sort = {"marketPrice"}, direction = Sort.Direction.DESC) Pageable pageable) {
        // 检查返回size，避免返回过大数据
        int maxSize = 100;
        if (pageable.getPageSize() > maxSize) {
            throw new IllegalArgumentException("超过最大返回数据量：" + maxSize);
        }
        return statisticService.findAllItemStatistic(pageable);
    }

    /**
     * 查询某个物品的统计历史
     *
     * @param id
     * @param bonusList
     * @return
     */
    @GetMapping("/{id}/statistics")
    public List<ItemStatistic> findStatisticsByItem(@PathVariable("id") Integer id, @RequestParam(value = "bonusList", defaultValue = "") String bonusList) {
        return statisticService.findItemStatisticsByItemIdAndBonusList(id, bonusList);
    }

}
