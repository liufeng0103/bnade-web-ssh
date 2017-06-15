package com.bnade.wow.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by liufeng0103@163.com on 2017/6/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuctionRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(AuctionRepositoryTest.class);

    @Autowired
    private AuctionRepository auctionRepository;

    @Test
    public void findByItemId() throws Exception {
        logger.info("{}", auctionRepository.findByRealmIdAndItemId(1, 124105));
    }

}