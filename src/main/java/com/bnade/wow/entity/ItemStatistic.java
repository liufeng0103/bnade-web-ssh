package com.bnade.wow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 物品搜索统计
 * Created by liufeng0103@163.com on 2017/7/12.
 */
@Entity
public class ItemStatistic implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer itemId;
    private String bonusList;
    private Integer petSpeciesId;
    private Integer petBreedId;
    private Long marketPrice;
    private Long cheapestPrice;
    private Integer realmQuantity;
    private Integer validRealmQuantity;
    private Integer quantity;
    private Timestamp validTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getBonusList() {
        return bonusList;
    }

    public void setBonusList(String bonusList) {
        this.bonusList = bonusList;
    }

    public Integer getPetSpeciesId() {
        return petSpeciesId;
    }

    public void setPetSpeciesId(Integer petSpeciesId) {
        this.petSpeciesId = petSpeciesId;
    }

    public Integer getPetBreedId() {
        return petBreedId;
    }

    public void setPetBreedId(Integer petBreedId) {
        this.petBreedId = petBreedId;
    }

    public Long getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Long marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Long getCheapestPrice() {
        return cheapestPrice;
    }

    public void setCheapestPrice(Long cheapestPrice) {
        this.cheapestPrice = cheapestPrice;
    }

    public Integer getRealmQuantity() {
        return realmQuantity;
    }

    public void setRealmQuantity(Integer realmQuantity) {
        this.realmQuantity = realmQuantity;
    }

    public Integer getValidRealmQuantity() {
        return validRealmQuantity;
    }

    public void setValidRealmQuantity(Integer validRealmQuantity) {
        this.validRealmQuantity = validRealmQuantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Timestamp getValidTime() {
        return validTime;
    }

    public void setValidTime(Timestamp validTime) {
        this.validTime = validTime;
    }

    @Override
    public String toString() {
        return "ItemStatistic{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", bonusList='" + bonusList + '\'' +
                ", petSpeciesId=" + petSpeciesId +
                ", petBreedId=" + petBreedId +
                ", marketPrice=" + marketPrice +
                ", cheapestPrice=" + cheapestPrice +
                ", realmQuantity=" + realmQuantity +
                ", validRealmQuantity=" + validRealmQuantity +
                ", quantity=" + quantity +
                ", validTime=" + validTime +
                '}';
    }
}
