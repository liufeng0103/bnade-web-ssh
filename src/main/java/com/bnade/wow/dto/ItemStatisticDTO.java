package com.bnade.wow.dto;

/**
 * Created by liufeng0103@163.com on 2017/8/12.
 */
public class ItemStatisticDTO {
    private Integer itemId;
    private String itemName;
    private String itemIcon;
    private Integer itemLevel;
    private String bonusList;
    private Long marketPrice;
    private Integer quantity;
    private Integer realmQuantity;

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

    public String getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(String itemIcon) {
        this.itemIcon = itemIcon;
    }

    public Integer getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(Integer itemLevel) {
        this.itemLevel = itemLevel;
    }

    public String getBonusList() {
        return bonusList;
    }

    public void setBonusList(String bonusList) {
        this.bonusList = bonusList;
    }

    public Long getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Long marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getRealmQuantity() {
        return realmQuantity;
    }

    public void setRealmQuantity(Integer realmQuantity) {
        this.realmQuantity = realmQuantity;
    }

    @Override
    public String toString() {
        return "ItemStatisticDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemIcon='" + itemIcon + '\'' +
                ", itemLevel=" + itemLevel +
                ", bonusList='" + bonusList + '\'' +
                ", marketPrice=" + marketPrice +
                ", quantity=" + quantity +
                ", realmQuantity=" + realmQuantity +
                '}';
    }
}
