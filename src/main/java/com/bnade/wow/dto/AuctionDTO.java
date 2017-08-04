package com.bnade.wow.dto;

/**
 * 拍卖数据信息
 * Created by liufeng0103@163.com on 2017/7/25.
 */
public class AuctionDTO {
    private Integer itemId;
    private String itemName;
    private Integer itemLevel;
    private String itemIcon;
    private String owner;
    private String ownerRealm;
    private Long bid;
    private Long buyout;
    private Integer quantity;
    private String timeLeft;
    private Integer petSpeciesId;
    private String petName;
    private String petIcon;
    private Integer petLevel;
    private Integer petBreedId;
    private String bonusList;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(Integer itemLevel) {
        this.itemLevel = itemLevel;
    }

    public String getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(String itemIcon) {
        this.itemIcon = itemIcon;
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

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetIcon() {
        return petIcon;
    }

    public void setPetIcon(String petIcon) {
        this.petIcon = petIcon;
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

    public String getBonusList() {
        return bonusList;
    }

    public void setBonusList(String bonusList) {
        this.bonusList = bonusList;
    }

    @Override
    public String toString() {
        return "AuctionDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemLevel=" + itemLevel +
                ", itemIcon='" + itemIcon + '\'' +
                ", owner='" + owner + '\'' +
                ", ownerRealm='" + ownerRealm + '\'' +
                ", bid=" + bid +
                ", buyout=" + buyout +
                ", quantity=" + quantity +
                ", timeLeft='" + timeLeft + '\'' +
                ", petSpeciesId=" + petSpeciesId +
                ", petName='" + petName + '\'' +
                ", petIcon='" + petIcon + '\'' +
                ", petLevel=" + petLevel +
                ", petBreedId=" + petBreedId +
                ", bonusList='" + bonusList + '\'' +
                '}';
    }
}
