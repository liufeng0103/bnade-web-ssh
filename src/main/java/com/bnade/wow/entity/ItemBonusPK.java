package com.bnade.wow.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 物品奖励主键
 * Created by liufeng0103@163.com on 2017/6/27.
 */
public class ItemBonusPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer itemId;
    private String bonusList;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemBonusPK that = (ItemBonusPK) o;

        if (!itemId.equals(that.itemId)) return false;
        return bonusList.equals(that.bonusList);
    }

    @Override
    public int hashCode() {
        int result = itemId.hashCode();
        result = 31 * result + bonusList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ItemBonusPK{" +
                "itemId=" + itemId +
                ", bonusList='" + bonusList + '\'' +
                '}';
    }
}
