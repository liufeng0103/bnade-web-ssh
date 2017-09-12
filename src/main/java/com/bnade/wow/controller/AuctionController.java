package com.bnade.wow.controller;

import com.bnade.wow.dto.AuctionDTO;
import com.bnade.wow.dto.TopOwnerDTO;
import com.bnade.wow.entity.Auction;
import com.bnade.wow.entity.Item;
import com.bnade.wow.entity.Pet;
import com.bnade.wow.service.AuctionService;
import com.bnade.wow.service.ItemService;
import com.bnade.wow.service.PetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
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
    @Autowired
    private ItemService itemService;
    @Autowired
    private PetService petService;

    /**
     * 查询某个服务器下的拍卖数据信息
     * @param auction 查询条件
     * @return 所有满足条件的拍卖数据
     */
    @GetMapping
    public List<AuctionDTO> findAll(@Valid Auction auction) {
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
        List<Auction> auctions = auctionService.findAll(auction);
        List<AuctionDTO> auctionDTOList = new ArrayList<>(auctions.size());
        for (Auction auc : auctions) {
            AuctionDTO auctionDTO = new AuctionDTO();
            BeanUtils.copyProperties(auc, auctionDTO);
            if (Item.PET_CAGE_ID != auc.getItemId()) {
                Item item = itemService.findById(auc.getItemId());
                if (item != null) {
                    auctionDTO.setItemName(item.getName());
                    auctionDTO.setItemLevel(item.getLevel());
                    auctionDTO.setItemIcon(item.getIcon());
                }
            } else {
                auctionDTO.setItemName("宠物笼");
                auctionDTO.setItemLevel(20);
                auctionDTO.setItemIcon("inv_box_petcarrier_01");
                Pet pet = petService.findById(auc.getPetSpeciesId());
                if (pet != null) {
                    auctionDTO.setPetName(pet.getName());
                    auctionDTO.setPetIcon(pet.getIcon());
                }
            }
            auctionDTOList.add(auctionDTO);
        }
        return auctionDTOList;
    }

    @GetMapping("/top-owners")
    public List<TopOwnerDTO> getTopOwnerByRealmId(@RequestParam(value = "realmId")Integer realmId) {
        if (realmId == null) {
            throw new IllegalArgumentException("服务器id不能为空");
        }
        return auctionService.getTopOwnerByRealmId(realmId);
    }

}
