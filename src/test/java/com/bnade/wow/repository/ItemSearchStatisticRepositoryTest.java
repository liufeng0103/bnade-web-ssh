package com.bnade.wow.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liufeng0103@163.com on 2017/7/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemSearchStatisticRepositoryTest {

    @Autowired
    private ItemSearchStatisticRepository itemSearchStatisticRepository;

    @Test
    public void findStartFromTest() throws Exception {
        System.out.println(itemSearchStatisticRepository.findStartFrom("2017-07-13", 0, 10));
    }

}