package com.bnade.wow.entity;

import javax.persistence.*;
import java.util.List;

/**
 * 物品信息
 * Created by liufeng0103@163.com on 2017/6/27.
 */
@Entity
public class Item {
    @Id
    private Integer id;
    private String name;
    private String icon;
    private Integer itemClass;
    private Integer itemSubClass;
    private Integer inventoryType;
    private Integer itemLevel;
    private Integer hot;
    @Transient // 表示非表列
    private List<String> bonusList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getItemClass() {
        return itemClass;
    }

    public void setItemClass(Integer itemClass) {
        this.itemClass = itemClass;
    }

    public Integer getItemSubClass() {
        return itemSubClass;
    }

    public void setItemSubClass(Integer itemSubClass) {
        this.itemSubClass = itemSubClass;
    }

    public Integer getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(Integer inventoryType) {
        this.inventoryType = inventoryType;
    }

    public Integer getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(Integer itemLevel) {
        this.itemLevel = itemLevel;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public List<String> getBonusList() {
        return bonusList;
    }

    public void setBonusList(List<String> bonusList) {
        this.bonusList = bonusList;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", itemClass=" + itemClass +
                ", itemSubClass=" + itemSubClass +
                ", inventoryType=" + inventoryType +
                ", itemLevel=" + itemLevel +
                ", hot=" + hot +
                ", bonusList=" + bonusList +
                '}';
    }
}
