package com.bnade.wow.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 时光徽章
 * Created by liufeng0103@163.com on 2017/6/6.
 */
@Entity
public class WowToken {
    @Id
    private Long updated;

    private Integer buy;

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public Integer getBuy() {
        return buy;
    }

    public void setBuy(Integer buy) {
        this.buy = buy;
    }

    @Override
    public String toString() {
        return "Wowtoken{" +
                "updated=" + updated +
                ", buy=" + buy +
                '}';
    }
}
