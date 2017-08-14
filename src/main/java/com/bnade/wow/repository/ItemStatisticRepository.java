package com.bnade.wow.repository;

import com.bnade.wow.entity.ItemStatistic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Timestamp;

/**
 * 物品统计
 *
 * Created by liufeng0103@163.com on 2017/8/9.
 */
public interface ItemStatisticRepository extends PagingAndSortingRepository<ItemStatistic, Integer>,JpaRepository<ItemStatistic, Integer> {

    Page<ItemStatistic> findByValidTime(Timestamp timestamp, Pageable pageable);

}
