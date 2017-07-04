package com.bnade.wow.config;

import com.bnade.wow.interceptor.CORSInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Web相关配置
 * Created by liufeng0103@163.com on 2017/7/4.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 添加跨域请求过滤器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CORSInterceptor()).addPathPatterns("/**");
    }
}
