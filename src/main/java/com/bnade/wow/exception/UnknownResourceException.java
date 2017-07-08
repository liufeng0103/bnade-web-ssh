package com.bnade.wow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 找不到资源异常
 * Created by liufeng0103@163.com on 2017/6/13.
 */
public class UnknownResourceException extends RuntimeException {

    public UnknownResourceException() {
        super();
    }

    public UnknownResourceException(String message) {
        super(message);
    }
}
