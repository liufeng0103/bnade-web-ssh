package com.bnade.wow.exception;

import com.bnade.wow.enums.ResultEnum;

/**
 * Created by liufeng0103@163.com on 2017/6/12.
 */
public class BnadeException extends RuntimeException {
    private Integer code;

    public BnadeException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
