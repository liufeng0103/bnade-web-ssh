package com.bnade.wow.handle;

import com.bnade.wow.dto.Result;
import com.bnade.wow.exception.BnadeException;
import com.bnade.wow.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liufeng0103@163.com on 2017/6/6.
 */
//@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof BnadeException) {
            BnadeException bnadeException = (BnadeException) e;
            return ResultUtils.error(bnadeException.getCode(), bnadeException.getMessage());
        } else {
            logger.info("{}", e);
            return ResultUtils.error(-1, "未知错误");
        }
    }
}
