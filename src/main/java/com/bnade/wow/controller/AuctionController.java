package com.bnade.wow.controller;

import com.bnade.wow.entity.Auction;
import com.bnade.wow.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 对拍卖数据的操作
 * Created by liufeng0103@163.com on 2017/6/12.
 */
@RestController
@RequestMapping("/auctions")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    /**
     * 查询某个服务器下的拍卖数据信息
     * @param auction 查询条件
     * @return 所有满足条件的拍卖数据
     */
    @GetMapping
    public List<Auction> findAll(@Valid Auction auction) {
        /**
         * auction的bonusList为null时，查询时bonusList将不作为查询条件，这样会查询所有bonusList类型的物品
         * 而""是一种bonusList类型，get url无法传值""给bonusList
         * 所以这里约定，如果为null则认为是""， 当指定all是则是查询所有bonusList类型，所以为null
         * 当条件指定owner时，我们希望查询这个卖家所有bonusList类型的物品，所以不指定owner和bonusList时才设为""
         */
        if (null == auction.getOwner() && null == auction.getBonusList()) {
            auction.setBonusList("");
        } else if ("all".equals(auction.getBonusList())) {
            auction.setBonusList(null);
        }
        return auctionService.findAll(auction);
    }

}
