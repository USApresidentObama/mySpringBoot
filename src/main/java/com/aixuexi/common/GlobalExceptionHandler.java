package com.aixuexi.common;

import com.aixuexi.liuaotest.exception.LiuaoException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LiuaoException.class)
    public ResultData bizHandler(LiuaoException e) {
        return ResultData.fail(e.getMessage(), e.getImessageCode().getCode());
    }

    @ExceptionHandler(Exception.class)
    public ResultData errorHandler(Exception e) {
        return ResultData.fail("系统错误");
    }

}
