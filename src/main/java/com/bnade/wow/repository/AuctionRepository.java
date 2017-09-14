package com.bnade.wow.repository;

import com.bnade.wow.entity.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by liufeng0103@163.com on 2017/6/12.
 */
public interface AuctionRepository extends JpaRepository<Auction, Integer>, JpaSpecificationExecutor<Auction> {

    List<Auction> findByRealmIdAndItemId(Integer realmId, Integer itemId);

    /**
     * 卖家拍卖总价值排行
     *
     * @param realmId 服务器ID
     * @param limit 返回条数
     * @return
     */
    @Query(value = "select a.owner,sum(i.market_price*a.quantity) from auction a join item_statistic i on a.item_id=i.item_id and a.bonus_list=i.bonus_list and i.valid_time='9999-12-31 00:00:00' where a.realm_id=?1 group by a.owner order by sum(i.market_price*a.quantity) desc LIMIT 0,?2", nativeQuery = true)
    List<Object[]> getOwnerTopWorths(int realmId, int limit);

    /**
     * 卖家拍卖种类排行
     *
     * @param realmId 服务器ID
     * @param limit 返回条数
     * @return
     */
    @Query(value = "select owner,count(distinct item_id) from auction where realm_id=?1 group by owner order by count(distinct item_id) desc LIMIT 0,?2", nativeQuery = true)
    List<Object[]> getOwnerTopSepcies(int realmId, int limit);

    /**
     * 卖家拍卖总数量排行
     *
     * @param realmId 服务器ID
     * @param limit 返回条数
     * @return
     */
    @Query(value = "select owner,sum(quantity) from auction where realm_id=?1 group by owner order by sum(quantity) desc LIMIT 0,?2", nativeQuery = true)
    List<Object[]> getOwnerTopQuantities(int realmId, int limit);

}
