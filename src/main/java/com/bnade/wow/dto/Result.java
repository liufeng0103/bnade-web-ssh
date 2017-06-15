package com.bnade.wow.dto;

/**
 * http请求返回的最外层对象
 * Created by liufeng0103@163.com on 2017/6/12.
 */
public class Result<T> {
    // 错误码
    private Integer code;
    // 提示信息
    private String msg;
    // 具体内容
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
