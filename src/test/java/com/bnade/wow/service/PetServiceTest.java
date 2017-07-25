package com.bnade.wow.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by liufeng0103@163.com on 2017/7/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PetServiceTest {

    @Autowired
    private PetService petService;

    @Test
    public void testFindById() throws Exception {
        System.out.println(petService.findById(39));
    }

}