package com.bnade.wow.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 物品搜索统计
 * Created by liufeng0103@163.com on 2017/7/12.
 */
@Entity
public class ItemSearchStatistic {

    @Id
    private Integer id;
    private Integer itemId;
    private Integer searchCount;

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

    public Integer getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(Integer searchCount) {
        this.searchCount = searchCount;
    }

    @Override
    public String toString() {
        return "ItemSearchStatistic{" +
                "itemId=" + itemId +
                ", searchCount=" + searchCount +
                '}';
    }
}
