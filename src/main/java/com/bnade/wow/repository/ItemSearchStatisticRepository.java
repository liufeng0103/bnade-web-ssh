package com.bnade.wow.repository;

import com.bnade.wow.entity.ItemSearchStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 物品搜索统计
 * Created by liufeng0103@163.com on 2017/7/13.
 */
public interface ItemSearchStatisticRepository extends JpaRepository<ItemSearchStatistic, Integer> {

    /**
     * 查询指定日期之后的物品搜索次数统计
     * @param startDate 查询的开始日期
     * @param offset 偏移
     * @param limit 返回记录数
     * @return 每种物品搜索的列表
     */
    @Query(value = "SELECT item_id,SUM(search_count) FROM item_search_statistic WHERE search_date>=?1 GROUP BY item_id ORDER BY SUM(search_count) DESC LIMIT ?2,?3", nativeQuery = true)
    List<Object[]> findStartFrom(String startDate, Integer offset, Integer limit);

}
