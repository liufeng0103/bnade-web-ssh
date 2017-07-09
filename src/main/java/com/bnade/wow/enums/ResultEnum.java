package com.bnade.wow.enums;

/**
 * 结果的code枚举
 * Created by liufeng0103@163.com on 2017/6/12.
 */
public enum ResultEnum {
    SUCCESS(200, "成功"),
    NOT_FOUND(404, "资源不存在"),
    BAD_REQUEST(400, "请求不正确,请检查调用参数"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
            ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
