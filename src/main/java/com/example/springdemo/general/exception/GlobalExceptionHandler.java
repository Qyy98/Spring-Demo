package com.example.springdemo.general.exception;

import com.example.springdemo.general.CommonResult;
import com.example.springdemo.constant.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * ExceptionHandler
 *
 * @Description
 * @Author QianYiyu
 * @Date 2022/08/28 10:35
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * @description 参数类型不匹配异常
     * @param e 异常
     * @return com.example.springdemo.general.CommonResult<java.lang.Object>
     * @author QianYiyu
     * @date 2022/08/28 11:45
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public CommonResult<Object> argumentException(MethodArgumentTypeMismatchException e) {
        log.error(e.getMessage(), e);
        return CommonResult.fail(StatusCode.PARAM_ERROR, StatusCode.PARAM_ERROR.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResult<Object> exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return CommonResult.fail(StatusCode.UNKNOWN_ERROR, StatusCode.UNKNOWN_ERROR.getMessage());
    }
}
