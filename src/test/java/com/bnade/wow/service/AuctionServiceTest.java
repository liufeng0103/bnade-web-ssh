package com.bnade.wow.service;

import com.bnade.wow.entity.Auction;
import com.bnade.wow.repository.AuctionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by liufeng0103@163.com on 2017/6/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuctionServiceTest {

    @Autowired
    private AuctionService auctionService;

    @Test
    public void findAll() throws Exception {
        Auction auction = new Auction();
        auction.setRealmId(1);
        auction.setItemId(124105);
        System.out.println(auctionService.findAll(auction));
        auction = new Auction();
        auction.setRealmId(1);
        auction.setOwner("世界树林");
        System.out.println(auctionService.findAll(auction));

    }

}