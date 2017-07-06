package com.bnade.wow.service;

import com.bnade.wow.dto.CheapestAuctionDTO;
import com.bnade.wow.entity.CheapestAuction;
import com.bnade.wow.entity.Realm;
import com.bnade.wow.repository.CheapestAuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * 最低一口价拍卖
 * Created by liufeng0103@163.com on 2017/6/12.
 */
@Service
public class CheapestAuctionService {

    @Autowired
    private CheapestAuctionRepository cheapestAuctionRepository;
    @Autowired
    private RealmService realmService;
    /**
     * 多条件查询
     * @param auction 查询条件
     * @return List
     */
    public List<CheapestAuction> findAll(final CheapestAuction auction) {
        // 参数验证，物品id不能为空
        if (null == auction.getItemId()) {
            throw new IllegalArgumentException("最低一口价查询物品id不能为空");
        }
        return cheapestAuctionRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
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
            criteriaQuery.where(list.toArray(new Predicate[list.size()]));
            return null;
        });
    }

    /**
     * 查询所有满足条件的最低一口价拍卖
     * 同时获取服务器的人气
     * @param auction 查询条件
     * @return List
     */
    public List<CheapestAuctionDTO> findAllCheapest(CheapestAuction auction) {
        List<CheapestAuction> aucs = findAll(auction);
        List<CheapestAuctionDTO> auctionDTOs = new ArrayList<>(aucs.size());
        for (CheapestAuction auc : aucs) {
            Realm realm = realmService.findById(auc.getRealmId());
            CheapestAuctionDTO auctionDTO = new CheapestAuctionDTO();
            auctionDTO.setBuyout(auc.getBuyout());
            auctionDTO.setOwner(auc.getOwner());
            auctionDTO.setTimeLeft(auc.getTimeLeft());
            auctionDTO.setQuantity(auc.getQuantity());
            auctionDTO.setTotalQuantity(auc.getTotalQuantity());
            auctionDTO.setRealmId(auc.getRealmId());
            auctionDTO.setOwnerQuantity(realm.getOwnerQuantity());
            auctionDTOs.add(auctionDTO);
        }
        return auctionDTOs;
    }
}
