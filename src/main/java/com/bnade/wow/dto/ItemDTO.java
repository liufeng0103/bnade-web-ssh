package com.bnade.wow.dto;

import java.util.List;

import com.bnade.wow.entity.PetStats;

/**
 * 物品信息
 * Created by liufeng0103@163.com on 2017/6/27.
 */
public class ItemDTO {

    private Integer id;
    private String name;
    private String icon;
    private Integer itemClass;
    private Integer itemSubClass;
    private Integer inventoryType;
    private Integer level;
    private Integer petSpeciesId;
    private List<String> bonusLists;
    private List<PetStats> petStatsList;
    
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

    public List<String> getBonusLists() {
        return bonusLists;
    }

    public void setBonusLists(List<String> bonusLists) {
        this.bonusLists = bonusLists;
    }

    public List<PetStats> getPetStatsList() {
		return petStatsList;
	}

	public void setPetStatsList(List<PetStats> petStatsList) {
		this.petStatsList = petStatsList;
	}

	public Integer getPetSpeciesId() {
		return petSpeciesId;
	}

	public void setPetSpeciesId(Integer petSpeciesId) {
		this.petSpeciesId = petSpeciesId;
	}

	@Override
	public String toString() {
		return "ItemDTO [id=" + id + ", name=" + name + ", icon=" + icon + ", itemClass=" + itemClass
				+ ", itemSubClass=" + itemSubClass + ", inventoryType=" + inventoryType + ", level=" + level
				+ ", bonusLists=" + bonusLists + "]";
	}

}
