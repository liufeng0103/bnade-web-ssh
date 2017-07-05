package com.bnade.wow.repository;

import com.bnade.wow.entity.Auction;
import com.bnade.wow.entity.CheapestAuction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 最低一口价拍卖数据
 * Created by liufeng0103@163.com on 2017/6/12.
 */
public interface CheapestAuctionRepository extends JpaRepository<CheapestAuction, Integer>, JpaSpecificationExecutor<CheapestAuction> {

}
