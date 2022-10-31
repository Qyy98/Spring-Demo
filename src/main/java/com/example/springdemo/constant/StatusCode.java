package com.example.springdemo.constant;

/**
 * StatusCode
 *
 * @Description
 * @Author QianYiyu
 * @Date 2022/08/26 14:42
 */
public enum StatusCode {

    //region 特殊
    SUCCESS(0, "成功"),
    UNKNOWN_ERROR(-1, "未知错误"),
    //endregion

    //---------------------------------------

    //region 100xx 系统级错误
    SYSTEM_ERROR(10000, "系统错误"),
    //endregion

    //---------------------------------------

    //region 200xx 服务级公共错误
    PARAM_ERROR(20001, "参数错误");
    //endregion

    final int code;

    final String message;

    StatusCode(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}