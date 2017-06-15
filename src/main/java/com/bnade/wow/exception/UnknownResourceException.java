package com.bnade.wow.exception;

/**
 * 找不到资源异常
 * Created by liufeng0103@163.com on 2017/6/13.
 */
public class UnknownResourceException extends RuntimeException {

    public UnknownResourceException(String message) {
        super(message);
    }
}
