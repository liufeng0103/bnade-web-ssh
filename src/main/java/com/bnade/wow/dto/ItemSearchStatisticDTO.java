package com.bnade.wow.dto;

/**
 * 物品搜索统计
 * Created by liufeng0103@163.com on 2017/7/12.
 */
public class ItemSearchStatisticDTO {
    
    public static final int DAILY = 1;
    public static final int WEEKLY = 2;
    public static final int MONTHLY = 3;

    private Integer itemId;
    private String itemName;
    private Integer searchCount;
    private Integer type;

    public ItemSearchStatisticDTO() {
    }

    public ItemSearchStatisticDTO(Integer itemId, String itemName, Integer searchCount, Integer type) {
        this.itemId = itemId;
        this.itemName = itemName;
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
                ", itemName=" + itemName +
                ", searchCount=" + searchCount +
                ", type=" + type +
                '}';
    }
}
