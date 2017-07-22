package com.bnade.wow.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by liufeng0103@163.com on 2017/7/23.
 */
public class HttpUtilsTest {

    @Test(expected = FileNotFoundException.class)
    public void testGetFileNotFoundException() throws Exception {
        System.out.println(HttpUtils.get("https://www.battlenet.com.cn/wow/zh/item/-1/tooltip"));
    }

}