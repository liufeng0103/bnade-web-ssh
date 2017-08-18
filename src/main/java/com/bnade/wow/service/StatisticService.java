package com.bnade.wow.service;

import com.bnade.wow.dto.ItemSearchStatisticDTO;
import com.bnade.wow.entity.Item;
import com.bnade.wow.entity.ItemStatistic;
import com.bnade.wow.repository.ItemRepository;
import com.bnade.wow.repository.ItemSearchStatisticRepository;
import com.bnade.wow.repository.ItemStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 数据统计服务
 * Created by liufeng0103@163.com on 2017/7/11.
 */
@Service
public class StatisticService {

    private static final Timestamp VALID_TIMESTAMP = Timestamp.valueOf(LocalDateTime.of(9999, Month.DECEMBER, 31, 0, 0, 0));

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemStatisticRepository itemStatisticRepository;
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
        return getItemSearchStatisticsAsync();
    }

    /**
     * 异步获取每日，每周，每月的统计数据
     * @return 统计列表包含每日，每周，每月的统计数据
     */
    private List<ItemSearchStatisticDTO> getItemSearchStatisticsAsync() {
        List<ItemSearchStatisticDTO> itemSearchStatisticDTOList = new ArrayList<>(30);
        int size = 10;

        // 每日
        LocalDate todayDate = LocalDate.now();
        Future<List<Object[]>> itemDailySearchStatistics = findDateSearchStatistics(todayDate.toString(), size);
        // 每周
        LocalDate beforeWeekDate = todayDate.plusDays(-7);
        Future<List<Object[]>> itemWeeklySearchStatistics = findDateSearchStatistics(beforeWeekDate.toString(), size);
        // 每月
        LocalDate beforeMonthDate = todayDate.plusMonths(-30);
        Future<List<Object[]>> itemMonthlySearchStatistics = findDateSearchStatistics(beforeMonthDate.toString(), size);
        fillItemSearchStatisticList(itemSearchStatisticDTOList, itemDailySearchStatistics, ItemSearchStatisticDTO.DAILY);
        fillItemSearchStatisticList(itemSearchStatisticDTOList, itemWeeklySearchStatistics, ItemSearchStatisticDTO.WEEKLY);
        fillItemSearchStatisticList(itemSearchStatisticDTOList, itemMonthlySearchStatistics, ItemSearchStatisticDTO.MONTHLY);
        return itemSearchStatisticDTOList;
    }

    /**
     * 异步获取某个日期之后的搜索统计数据
     * @param date 搜索开始日期
     * @param size 返回数据数
     * @return 结果列表
     */
    private Future<List<Object[]>> findDateSearchStatistics(String date, int size) {
        return CompletableFuture.supplyAsync(() -> itemSearchStatisticRepository.findStartFrom(date.toString(), 0, size));
    }

    /**
     * 把搜索结果放到List itemSearchStatisticDTOList中
     * @param itemSearchStatisticDTOList 搜索结果列表
     * @param itemDateSearchStatistics 搜索数据
     * @param type 搜索数据类型， 每日，每周还是每月
     */
    private void fillItemSearchStatisticList(List<ItemSearchStatisticDTO> itemSearchStatisticDTOList, Future<List<Object[]>> itemDateSearchStatistics, int type) {
        try {
            for (Object[] itemSearchStatistic : itemDateSearchStatistics.get(3, TimeUnit.SECONDS)) {
                int itemId = ((Number)itemSearchStatistic[0]).intValue();
                int searchCount = ((Number)itemSearchStatistic[1]).intValue();
                Item item = itemRepository.findOne(itemId);
                itemSearchStatisticDTOList.add(new ItemSearchStatisticDTO(itemId, item.getName(), searchCount, type));
            }
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询物品统计
     *
     * @param pageable
     * @return
     */
    @Cacheable(cacheNames = "itemStatistics", keyGenerator="customKeyGenerator")
    public List<ItemStatistic> findAllItemStatistic(Pageable pageable) {
        // 只查valid_time是9999-12-31的数据
        return itemStatisticRepository.findByValidTime(VALID_TIMESTAMP, pageable).getContent();
    }

    /**
     * 查询某个物品的统计历史
     *
     * @param id
     * @param bonusList
     * @return
     */
    public List<ItemStatistic> findItemStatisticsByItemIdAndBonusList(Integer id, String bonusList) {
        return itemStatisticRepository.findByItemIdAndBonusListAndValidTimeNot(id, bonusList, VALID_TIMESTAMP);
    }

}
