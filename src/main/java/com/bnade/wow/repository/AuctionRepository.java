package com.bnade.wow.repository;

import com.bnade.wow.entity.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by liufeng0103@163.com on 2017/6/12.
 */
public interface AuctionRepository extends JpaRepository<Auction, Integer>, JpaSpecificationExecutor<Auction> {

    List<Auction> findByRealmIdAndItemId(Integer realmId, Integer itemId);

}
