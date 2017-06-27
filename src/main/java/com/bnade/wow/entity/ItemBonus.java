package com.bnade.wow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 物品奖励
 * Created by liufeng0103@163.com on 2017/6/27.
 */
@Entity
public class ItemBonus {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer itemId;
    private String bonusList;
    private Integer context;

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

    public Integer getContext() {
        return context;
    }

    public void setContext(Integer context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "ItemBonus{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", bonusList='" + bonusList + '\'' +
                ", context=" + context +
                '}';
    }
}
