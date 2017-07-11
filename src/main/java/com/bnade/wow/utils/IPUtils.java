package com.bnade.wow.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * IP工具类
 * Created by liufeng0103@163.com on 2017/7/11.
 */
public class IPUtils {

    private IPUtils() {
    }

    /**
     * 通过HttpServletRequest获取ip地址
     * 参考 http://www.cnblogs.com/ITtangtang/p/3927768.html
     * @param request 通过HttpServletRequest获取ip地址
     * @return ip地址
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }
}
