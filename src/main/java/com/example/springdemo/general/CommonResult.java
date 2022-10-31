package com.example.springdemo.general;

import com.example.springdemo.constant.StatusCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * CommonResult
 *
 * @Description
 * @Author QianYiyu
 * @Date 2022/08/26 14:40
 */
@ApiModel(value = "通用返回结果", description = "通用返回结果")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResult<T> {

    @ApiModelProperty(value = "状态码")
    private int code;

    @ApiModelProperty(value = "信息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data;

    private CommonResult() {}

    public static <T> CommonResult<T> success() {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(StatusCode.SUCCESS.getCode());
        result.setMessage(StatusCode.SUCCESS.getMessage());
        return result;
    }

    public static <T> CommonResult<T> success(String message) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(StatusCode.SUCCESS.getCode());
        result.setMessage(message);
        return result;
    }

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(StatusCode.SUCCESS.getCode());
        result.setMessage(StatusCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }


    public static <T> CommonResult<T> success(String message, T data) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(StatusCode.SUCCESS.getCode());
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> CommonResult<T> fail(StatusCode code, String message) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(code.getCode());
        result.setMessage(message);
        return result;
    }

    public static <T> CommonResult<T> fail(StatusCode code, String message, T data) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(code.getCode());
        result.setMessage(message);
        result.setData(data);
        return result;
    }


    public int getCode() { return code; }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}