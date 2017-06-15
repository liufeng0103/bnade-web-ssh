package com.bnade.wow.utils;

import com.bnade.wow.dto.Result;

/**
 * 生成Result的工具类
 * Created by liufeng0103@163.com on 2017/6/12.
 */
public class ResultUtils {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
