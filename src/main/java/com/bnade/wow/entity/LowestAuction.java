package com.bnade.wow.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 最低一口价拍卖数据
 * Created by liufeng0103@163.com on 2017/6/11.
 */
public class LowestAuction {
    @Id
    @GeneratedValue
    private Long id;
    private Integer auc;
    private Integer itemId;
    private String owner;
    private String ownerRealm;
    private Long bid;
    private Long buyout;
    private Integer quantity;
    private Integer totalQuantity;
    private String timeLeft;
    private Integer petSpeciesId;
    private Integer petLevel;
    private Integer petBreedId;
    private Integer context;
    private String bonusList;
    private Integer realmId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAuc() {
        return auc;
    }

    public void setAuc(Integer auc) {
        this.auc = auc;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerRealm() {
        return ownerRealm;
    }

    public void setOwnerRealm(String ownerRealm) {
        this.ownerRealm = ownerRealm;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Long getBuyout() {
        return buyout;
    }

    public void setBuyout(Long buyout) {
        this.buyout = buyout;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    public Integer getPetSpeciesId() {
        return petSpeciesId;
    }

    public void setPetSpeciesId(Integer petSpeciesId) {
        this.petSpeciesId = petSpeciesId;
    }

    public Integer getPetLevel() {
        return petLevel;
    }

    public void setPetLevel(Integer petLevel) {
        this.petLevel = petLevel;
    }

    public Integer getPetBreedId() {
        return petBreedId;
    }

    public void setPetBreedId(Integer petBreedId) {
        this.petBreedId = petBreedId;
    }

    public Integer getContext() {
        return context;
    }

    public void setContext(Integer context) {
        this.context = context;
    }

    public String getBonusList() {
        return bonusList;
    }

    public void setBonusList(String bonusList) {
        this.bonusList = bonusList;
    }

    public Integer getRealmId() {
        return realmId;
    }

    public void setRealmId(Integer realmId) {
        this.realmId = realmId;
    }

    @Override
    public String toString() {
        return "LowestAuction{" +
                "id=" + id +
                ", auc=" + auc +
                ", itemId=" + itemId +
                ", owner='" + owner + '\'' +
                ", ownerRealm='" + ownerRealm + '\'' +
                ", bid=" + bid +
                ", buyout=" + buyout +
                ", quantity=" + quantity +
                ", totalQuantity=" + totalQuantity +
                ", timeLeft='" + timeLeft + '\'' +
                ", petSpeciesId=" + petSpeciesId +
                ", petLevel=" + petLevel +
                ", petBreedId=" + petBreedId +
                ", context=" + context +
                ", bonusList='" + bonusList + '\'' +
                ", realmId=" + realmId +
                '}';
    }
}
