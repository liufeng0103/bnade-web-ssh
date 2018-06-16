package com.bnade.wow.dto;

/**
 * 宠物信息
 * Created by liufeng0103@163.com on 2017/7/25.
 */
public class PetDTO {
    private Integer id;
    private String name;
    private String icon;
    private Integer level;
    private Integer breedId;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getBreedId() {
        return breedId;
    }

    public void setBreedId(Integer breedId) {
        this.breedId = breedId;
    }

    @Override
    public String toString() {
        return "PetDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", level=" + level +
                ", breedId=" + breedId +
                '}';
    }
}
