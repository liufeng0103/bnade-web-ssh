package com.bnade.wow.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by liufeng0103@163.com on 2017/8/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemStatisticRepositoryTest {

    @Autowired
    private ItemStatisticRepository itemStatisticRepository;

    @Test
    public void test() {
        System.out.println(itemStatisticRepository.findOne(1));
    }
}