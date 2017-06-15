package com.bnade.wow.service;

import com.bnade.wow.entity.Auction;
import com.bnade.wow.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liufeng0103@163.com on 2017/6/12.
 */
@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    public List<Auction> findByRealmIdAndItemId(Integer realmId, Integer itemId) {
        return auctionRepository.findByRealmIdAndItemId(realmId, itemId);
    }

    /**
     * 多条件查询拍卖数据
     * @param auction
     * @return
     */
    public List<Auction> findAll(final Auction auction) {
        return auctionRepository.findAll(new Specification<Auction>() {
            @Override
            public Predicate toPredicate(Root<Auction> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (null != auction.getRealmId()) {
                    list.add(criteriaBuilder.equal(root.get("realmId"), auction.getRealmId()));
                }
                if (null != auction.getItemId()) {
                    list.add(criteriaBuilder.equal(root.get("itemId"), auction.getItemId()));
                }
                if (null != auction.getOwner()) {
                    list.add(criteriaBuilder.equal(root.get("owner"), auction.getOwner()));
                }
                criteriaQuery.where(list.toArray(new Predicate[list.size()]));
                return null;
            }
        });
    }
}
