package com.bnade.wow.aspect;

import com.bnade.wow.exception.UnknownResourceException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 资源切面,用于对controller关于RESTful相关的处理
 * Created by liufeng0103@163.com on 2017/6/6.
 */
@Aspect
@Component
public class ResourceAspect {

    private final static Logger logger = LoggerFactory.getLogger(ResourceAspect.class);

    @Around("execution(public * com.bnade.wow.controller.*.*(..))")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        Object returnValue = point.proceed(point.getArgs());
        // 找不到的资源返回UnknownResourceException异常，在异常处理中将http状态码设置为404
        if (returnValue == null) { // 空对象
            throw new UnknownResourceException();
        } else if (returnValue instanceof List && ((List) returnValue).size() == 0) { // 空数组
            throw new UnknownResourceException();
        }
        return returnValue;
    }


}
