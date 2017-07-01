package com.bnade.wow.entity;

import javax.persistence.*;

/**
 * 物品奖励
 * Created by liufeng0103@163.com on 2017/6/27.
 */
@Entity
@IdClass(ItemBonusPK.class)
public class ItemBonus {
    @Id
    private Integer itemId;
    @Id
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
    public String toString() {
        return "ItemBonus{" +
                "itemId=" + itemId +
                ", bonusList='" + bonusList + '\'' +
                '}';
    }
}
