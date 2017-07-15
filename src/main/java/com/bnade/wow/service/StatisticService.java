package com.bnade.wow.service;

import com.bnade.wow.dto.ItemSearchStatisticDTO;
import com.bnade.wow.entity.Item;
import com.bnade.wow.repository.ItemRepository;
import com.bnade.wow.repository.ItemSearchStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据统计服务
 * Created by liufeng0103@163.com on 2017/7/11.
 */
@Service
public class StatisticService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemSearchStatisticRepository itemSearchStatisticRepository;

    /**
     * 记录某个ip查询的物品id, 用于统计物品搜索情况
     * 把IP和itemId保存到redis的set中， 格式 k = ipxxx.xxx.xxx.xxx, v = 12345
     * @param ip IP
     * @param itemId 物品id
     */
    public void recordItemSearchedByIp(String ip, String itemId) {
        stringRedisTemplate.opsForSet().add("ip" + ip, itemId);
    }

    /**
     * 获取物品搜索统计
     * 目前返回每日，每周，每月各10条，以后需要可以扩展这个接口
     *
     * @return 统计结果列表
     */
    public List<ItemSearchStatisticDTO> findItemSearchStatistics() {
        List<ItemSearchStatisticDTO> itemSearchStatisticDTOList = new ArrayList<>(30);
        int size = 10;
        LocalDate todayDate = LocalDate.now();
        // 每日
        List<Object[]> itemDailySearchStatistics = itemSearchStatisticRepository.findStartFrom(todayDate.toString(), 0, size);
        for (Object[] itemSearchStatistic : itemDailySearchStatistics) {
            int itemId = ((Number)itemSearchStatistic[0]).intValue();
            int searchCount = ((Number)itemSearchStatistic[1]).intValue();
            Item item = itemRepository.findOne(itemId);
            itemSearchStatisticDTOList.add(new ItemSearchStatisticDTO(itemId, item.getName(), searchCount, ItemSearchStatisticDTO.DAILY));
        }
        // 每周
        LocalDate beforeWeekDate = todayDate.plusDays(-7);
        List<Object[]> itemWeeklySearchStatistics = itemSearchStatisticRepository.findStartFrom(beforeWeekDate.toString(), 0, size);
        for (Object[] itemSearchStatistic : itemWeeklySearchStatistics) {
            int itemId = ((Number)itemSearchStatistic[0]).intValue();
            int searchCount = ((Number)itemSearchStatistic[1]).intValue();
            Item item = itemRepository.findOne(itemId);
            itemSearchStatisticDTOList.add(new ItemSearchStatisticDTO(itemId, item.getName(), searchCount, ItemSearchStatisticDTO.WEEKLY));
        }
        // 每月
        LocalDate boforeMonthDate = todayDate.plusMonths(-30);
        List<Object[]> itemMonthlySearchStatistics = itemSearchStatisticRepository.findStartFrom(boforeMonthDate.toString(), 0, size);
        for (Object[] itemSearchStatistic : itemMonthlySearchStatistics) {
            int itemId = ((Number)itemSearchStatistic[0]).intValue();
            int searchCount = ((Number)itemSearchStatistic[1]).intValue();
            Item item = itemRepository.findOne(itemId);
            itemSearchStatisticDTOList.add(new ItemSearchStatisticDTO(itemId, item.getName(), searchCount, ItemSearchStatisticDTO.MONTHLY));
        }
        return itemSearchStatisticDTOList;
    }

}
