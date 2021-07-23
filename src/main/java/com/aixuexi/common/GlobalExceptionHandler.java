package com.aixuexi.common;

import com.aixuexi.liuaotest.exception.LiuaoException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LiuaoException.class)
    @ResponseBody
    public ResultData bizHandler(LiuaoException e) {
        return ResultData.fail(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultData errorHandler(Exception e) {
        return ResultData.fail("系统错误");
    }

}
