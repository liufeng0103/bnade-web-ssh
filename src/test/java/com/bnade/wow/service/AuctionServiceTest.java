package com.bnade.wow.service;

import com.bnade.wow.entity.Auction;
import com.bnade.wow.repository.AuctionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
    public void findAllTest() throws Exception {
        Auction auction = new Auction();
        auction.setRealmId(1);
        auction.setItemId(124105);
        System.out.println(auctionService.findAll(auction));
        auction = new Auction();
        auction.setRealmId(1);
        auction.setOwner("世界树林");
        System.out.println(auctionService.findAll(auction));

    }

    @Test
    public void findAllTest2() throws Exception {
        Auction auction = new Auction();
        auction.setRealmId(1);
        auction.setItemId(124105);
        List<Auction> auctions = auctionService.findAll(auction);
        ObjectMapper mapper = new ObjectMapper();
        FilterProvider filters = new SimpleFilterProvider().addFilter("auctionFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept("owner"));

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(auctions);
        mappingJacksonValue.setFilters(filters);
        System.out.println(mappingJacksonValue.getValue());
    }

    @Test
    public void getTopOwnerByRealmId() throws Exception {
        System.out.println(auctionService.getTopOwnerByRealmId(1));
    }
}