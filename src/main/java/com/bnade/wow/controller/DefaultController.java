package com.bnade.wow.controller;

import com.bnade.wow.exception.UnknownResourceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 默认控制器，在找不到请求映射时返回合适的响应
 * Created by liufeng0103@163.com on 2017/6/13.
 */
@Controller
public class DefaultController {
    
    @RequestMapping("/**")
    public void unmappedRequest(HttpServletRequest request) {
        String uri = request.getRequestURI();
        throw new UnknownResourceException("There is no resource for path " + uri);
    }
}
