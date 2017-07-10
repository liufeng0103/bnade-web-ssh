package com.bnade.wow.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liufeng0103@163.com on 2017/7/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemBonusRepositoryTest {

    @Autowired
    private ItemBonusRepository itemBonusRepository;

    @Test
    public void findBonusListByItemId() throws Exception {
        System.out.println(itemBonusRepository.findBonusListsByItemId(147422));
    }

}