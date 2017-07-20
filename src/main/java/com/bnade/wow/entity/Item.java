package com.bnade.wow.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/**
 * 物品信息
 * Created by liufeng0103@163.com on 2017/6/27.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true, value = {"icon", "itemClass", "itemSubClass", "inventoryType", "hot"})
//@JsonInclude(JsonInclude.Include.NON_NULL) json中属性为null时不生成该字段
public class Item {
    @Id
    private Integer id;
    private String name;
    private String icon;
    private Integer itemClass;
    private Integer itemSubClass;
    private Integer inventoryType;
    private Integer level;
    private Integer hot;
    @Transient // 表示非表列
    private List<String> bonusLists;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public List<String> getBonusLists() {
        return bonusLists;
    }

    public void setBonusLists(List<String> bonusLists) {
        this.bonusLists = bonusLists;
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
                ", level=" + level +
                ", hot=" + hot +
                ", bonusLists=" + bonusLists +
                '}';
    }
}
