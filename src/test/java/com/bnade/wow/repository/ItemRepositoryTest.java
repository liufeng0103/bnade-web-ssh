package com.bnade.wow.repository;

import com.bnade.wow.entity.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * ItemRepository单元测试
 * Created by liufeng0103@163.com on 2017/6/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void searchByNameTest() throws Exception {
        System.out.println(itemRepository.searchByName("玫瑰"));
    }

    @Test
    public void findOneTest() throws Exception {
        System.out.println(itemRepository.findOne(124105));
    }
}