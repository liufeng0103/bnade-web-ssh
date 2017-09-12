package com.bnade.wow.dto;

import java.io.Serializable;

/**
 * 用户排行
 *
 * Created by liufeng0103@163.com on 2017/9/12.
 */
public class TopOwnerDTO implements Serializable {

    public static final int WORTH = 1;
    public static final int SPECIES = 2;
    public static final int QUANTITY = 3;

    private String owner;
    private Object value;
    private Integer type;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TopOwnerDTO{" +
                "owner='" + owner + '\'' +
                ", value=" + value +
                ", type=" + type +
                '}';
    }
}
