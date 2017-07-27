package com.bnade.wow.service;

import com.bnade.wow.entity.Auction;
import com.bnade.wow.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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
        // 参数验证
        // 由于通过realmId分区表，为了避免所有分区搜索，参数必须有realmId
        if (null == auction.getRealmId()) {
            throw new IllegalArgumentException("服务器id不能为空");
        }
        // 由于还未对结果分页，不指定条件将有太多数据返回，暂时做限制处理，以后考虑分页
        if (null == auction.getItemId() && null == auction.getOwner()) {
            throw new IllegalArgumentException("物品id或卖家不能同时为空");
        }
        return auctionRepository.findAll((Root<Auction> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<Predicate>();
            if (null != auction.getRealmId()) {
                list.add(criteriaBuilder.equal(root.get("realmId"), auction.getRealmId()));
            }
            if (null != auction.getItemId()) {
                list.add(criteriaBuilder.equal(root.get("itemId"), auction.getItemId()));
            }
            if (null != auction.getBonusList()) {
                list.add(criteriaBuilder.equal(root.get("bonusList"), auction.getBonusList()));
            }
            if (null != auction.getPetSpeciesId()) {
                list.add(criteriaBuilder.equal(root.get("petSpeciesId"), auction.getPetSpeciesId()));
            }
            if (null != auction.getPetBreedId()) {
                list.add(criteriaBuilder.equal(root.get("petBreedId"), auction.getPetBreedId()));
            }
            if (null != auction.getOwner()) {
                list.add(criteriaBuilder.equal(root.get("owner"), auction.getOwner()));
            }
            criteriaQuery.where(list.toArray(new Predicate[list.size()]));
            return null;
        });
    }

}
