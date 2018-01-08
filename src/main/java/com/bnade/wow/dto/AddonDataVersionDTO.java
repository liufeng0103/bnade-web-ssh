package com.bnade.wow.dto;

/**
 * 插件数据版本
 *
 * Created by liufeng0103@163.com on 2018/1/8.
 */
public class AddonDataVersionDTO {
    private String version;

    public AddonDataVersionDTO() {
    }

    public AddonDataVersionDTO(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "AddonDataVersionDTO{" +
                "version='" + version + '\'' +
                '}';
    }
}
