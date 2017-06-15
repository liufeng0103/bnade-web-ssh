package com.bnade.wow.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liufeng0103@163.com on 2017/6/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WowTokenRepositoryTest {

    @Autowired
    private WowTokenRepository wowTokenRepository;

    @Test
    public void findALlTest() {
        System.out.println(wowTokenRepository.findAll());
    }

}