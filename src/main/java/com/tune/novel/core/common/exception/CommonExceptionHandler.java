package com.tune.novel.core.common.exception;

import com.tune.novel.core.common.constant.ErrorCodeEnum;
import com.tune.novel.core.common.resp.RestResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;

/**
 * @author Tune
 * @create 2023-12-07-22:19
 * @description:
 * 通用的异常处理器,
 * 处理系统异常、数据校验异常和我们自定义的业务异常
 */
@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {
    /**
     * 处理数据校验异常
     * */
    @ExceptionHandler(BindException.class)
    public RestResp<Void> handlerBindException(BindException e){
        log.error(e.getMessage(),e);
        return RestResp.fail(ErrorCodeEnum.USER_REQUEST_PARAM_ERROR);
    }

    /**
     * 处理业务异常
     * */
    @ExceptionHandler(BusinessException.class)
    public RestResp<Void> handlerBusinessException(BusinessException e){
        log.error(e.getMessage(),e);
        return RestResp.fail(e.getErrorCodeEnum());
    }

    /**
     * 处理系统异常
     * */
    @ExceptionHandler(Exception.class)
    public RestResp<Void> handlerException(Exception e){
        log.error(e.getMessage(),e);
        return RestResp.error();
    }
}
