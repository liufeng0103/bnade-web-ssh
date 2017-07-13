package com.bnade.wow.controller;

import com.bnade.wow.dto.CheapestAuctionDTO;
import com.bnade.wow.entity.CheapestAuction;
import com.bnade.wow.service.CheapestAuctionService;
import com.bnade.wow.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 最低一口价拍卖数据的操作
 * Created by liufeng0103@163.com on 2017/6/12.
 */
@RestController
@RequestMapping(value = {"/cheapest_auctions", "/cheapest-auctions"})
public class CheapestAuctionController {

    @Autowired
    private CheapestAuctionService cheapestAuctionService;

    /**
     * 查询某个服务器下的拍卖数据信息
     * @param auction 查询条件
     * @return 所有满足条件的拍卖数据
     */
    @GetMapping
    public List<CheapestAuctionDTO> findAll(@Valid CheapestAuction auction) {
        // BonusList默认为空
        if (null == auction.getBonusList()) {
            auction.setBonusList("");
        }
        return cheapestAuctionService.findAllCheapest(auction);
    }

}
