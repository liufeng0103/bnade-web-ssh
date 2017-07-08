package com.bnade.wow.utils;

import com.bnade.wow.dto.Result;
import com.bnade.wow.enums.ResultEnum;

/**
 * 生成Result的工具类
 * Created by liufeng0103@163.com on 2017/6/12.
 */
public class ResultUtils {

    public static Result success() {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setUrl("");
        return result;
    }

    public static Result error(Integer code, String msg, String url) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        result.setUrl(url);
        return result;
    }
}
