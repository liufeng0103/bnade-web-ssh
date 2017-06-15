package com.bnade.wow.controller;

import com.bnade.wow.entity.Auction;
import com.bnade.wow.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by liufeng0103@163.com on 2017/6/12.
 */
@RestController
@RequestMapping("/realms")
public class RealmController {

    @Autowired
    private AuctionService auctionService;
    @Autowired
    private AuctionController auctionController;

    /**
     * 查询某个服务器下的拍卖数据信息
     * @param realmId 服务器ID
     * @param auction 查询条件
     * @return 所有满足条件的拍卖数据
     */
    @GetMapping(value="/{realmId}/auctions")
    public List<Auction> getAuctions(@PathVariable("realmId") Integer realmId,
                                     Auction auction) {
        auction.setRealmId(realmId);
        return auctionController.findAll(auction);
    }
}
