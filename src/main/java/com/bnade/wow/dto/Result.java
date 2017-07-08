package com.bnade.wow.dto;

/**
 * http请求返回的最外层对象
 * Created by liufeng0103@163.com on 2017/6/12.
 */
public class Result {
    // 错误码
    private Integer code;
    // 提示信息
    private String message;
    // 请求url
    private String url;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
