package com.bnade.wow.enums;

/**
 * 结果的code枚举
 * Created by liufeng0103@163.com on 2017/6/12.
 */
public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    UNSUPPORT(100, "不支持"),
            ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
