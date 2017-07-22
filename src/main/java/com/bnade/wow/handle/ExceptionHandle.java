package com.bnade.wow.handle;

import com.bnade.wow.dto.Result;
import com.bnade.wow.enums.ResultEnum;
import com.bnade.wow.exception.UnknownResourceException;
import com.bnade.wow.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常全局处理
 * Created by liufeng0103@163.com on 2017/6/6.
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(UnknownResourceException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public Result handle404Error(HttpServletRequest req) {
        String url = req.getMethod() + " " + req.getRequestURL() + "?" + req.getQueryString();
        logger.debug("找不到url资源 {}", url);
        ResultEnum notFound = ResultEnum.NOT_FOUND;
        return ResultUtils.error(notFound.getCode(), notFound.getMessage(), url);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class,
            MissingServletRequestParameterException.class,
            MethodArgumentTypeMismatchException.class,
            HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result handle400Error(HttpServletRequest req, Exception e) {
        String url = req.getMethod() + " " + req.getRequestURL() + "?" + req.getQueryString();
        logger.debug("不合法的url请求: {}", url);
        ResultEnum badRequest = ResultEnum.BAD_REQUEST;
        return ResultUtils.error(badRequest.getCode(), badRequest.getMessage(), url);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Result handleError(HttpServletRequest req, Exception e) {
        String url = req.getMethod() + " " + req.getRequestURL() + "?" + req.getQueryString();
        logger.error("未知错误url: {}", url, e);
        ResultEnum serverError = ResultEnum.INTERNAL_SERVER_ERROR;
        return ResultUtils.error(serverError.getCode(), serverError.getMessage(), url);
    }
}
