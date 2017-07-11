package com.bnade.wow.utils;

/**
 * String工具类
 * Created by liufeng0103@163.com on 2017/7/11.
 */
public class StringUtils {

    private StringUtils() {}

    /**
     * 判断字符串不会空
     * @param s String
     * @return 是否为空
     */
    public static boolean isNotEmpty(String s) {
        return s != null && s.length() != 0;
    }
}
