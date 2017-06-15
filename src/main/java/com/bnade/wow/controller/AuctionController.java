package com.bnade.wow.controller;

import com.bnade.wow.dto.Result;
import com.bnade.wow.entity.Auction;
import com.bnade.wow.enums.ResultEnum;
import com.bnade.wow.exception.BnadeException;
import com.bnade.wow.service.AuctionService;
import com.bnade.wow.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liufeng0103@163.com on 2017/6/12.
 */
@RestController
@RequestMapping("/auctions")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    /**
     * 查询某个服务器下的拍卖数据信息
     * paramauction 查询条件
     * @return 所有满足条件的拍卖数据
     */
    @GetMapping
    public List<Auction> findAll(Auction auction) {
        return auctionService.findAll(auction);
    }

}
