package com.bnade.wow.dto;

import java.io.Serializable;

/**
 * 物品搜索统计
 * Created by liufeng0103@163.com on 2017/7/12.
 */
public class ItemSearchStatisticDTO implements Serializable {
    
    public static final int DAILY = 1;
    public static final int WEEKLY = 2;
    public static final int MONTHLY = 3;

    private Integer itemId;
    private String itemName;
    private String itemIcon;
    private Integer searchCount;
    private Integer type;

    public ItemSearchStatisticDTO() {
    }

    public ItemSearchStatisticDTO(Integer itemId, String itemName, String itemIcon, Integer searchCount, Integer type) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemIcon = itemIcon;
        this.searchCount = searchCount;
        this.type = type;
    }

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

    public Integer getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(Integer searchCount) {
        this.searchCount = searchCount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ItemSearchStatisticDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemIcon='" + itemIcon + '\'' +
                ", searchCount=" + searchCount +
                ", type=" + type +
                '}';
    }
}
