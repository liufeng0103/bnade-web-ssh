package com.bnade.wow.controller;

import com.bnade.wow.dto.AuctionDTO;
import com.bnade.wow.entity.Auction;
import com.bnade.wow.entity.Realm;
import com.bnade.wow.service.AuctionService;
import com.bnade.wow.service.RealmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liufeng0103@163.com on 2017/6/12.
 */
@RestController
@RequestMapping("/realms")
public class RealmController {

    @Autowired
    private RealmService realmService;
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
    public List<AuctionDTO> getAuctions(@PathVariable("realmId") Integer realmId,
                                        Auction auction) {
        auction.setRealmId(realmId);
        return auctionController.findAll(auction);
    }

    /**
     * 查询所有服务器信息
     * @return 服务器列表
     */
    @GetMapping
    public List<Realm> findAll() {
        return realmService.findAll();
    }
}
