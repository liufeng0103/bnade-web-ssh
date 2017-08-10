package com.bnade.wow.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liufeng0103@163.com on 2017/7/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticServiceTest {

    @Autowired
    private StatisticService statisticService;

    @Test
    public void testRecordItemSearchedByIp() throws Exception {
        statisticService.recordItemSearchedByIp("127.0.0.1", "1");
        statisticService.recordItemSearchedByIp("127.0.0.1", "2");
        statisticService.recordItemSearchedByIp("127.0.0.1", "3");
        statisticService.recordItemSearchedByIp("127.0.0.2", "4");
        statisticService.recordItemSearchedByIp("127.0.0.2", "13");
        statisticService.recordItemSearchedByIp("127.0.0.1", "2");
        statisticService.recordItemSearchedByIp("127.0.0.1", "1");
    }


    @Test
    public void testFindSearchStatistics() throws Exception {
        System.out.println(statisticService.findItemSearchStatistics());
    }

    @Test
    public void findAllItemStatistic() throws Exception {
        System.out.println(statisticService.findAllItemStatistic(1, 2));
    }
}