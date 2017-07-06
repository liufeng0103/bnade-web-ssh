package com.bnade.wow.dto;

/**
 * 最低一口价拍卖信息
 * Created by liufeng0103@163.com on 2017/7/6.
 */
public class CheapestAuctionDTO {
    private String owner;
    private Long buyout;
    private Integer quantity;
    private Integer totalQuantity;
    private String timeLeft;
    private Integer realmId;
    private Integer ownerQuantity;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public Integer getRealmId() {
        return realmId;
    }

    public void setRealmId(Integer realmId) {
        this.realmId = realmId;
    }

    public Integer getOwnerQuantity() {
        return ownerQuantity;
    }

    public void setOwnerQuantity(Integer ownerQuantity) {
        this.ownerQuantity = ownerQuantity;
    }

    @Override
    public String toString() {
        return "CheapestAuctionDTO{" +
                "owner='" + owner + '\'' +
                ", buyout=" + buyout +
                ", quantity=" + quantity +
                ", totalQuantity=" + totalQuantity +
                ", timeLeft='" + timeLeft + '\'' +
                ", realmId=" + realmId +
                ", ownerQuantity=" + ownerQuantity +
                '}';
    }
}
