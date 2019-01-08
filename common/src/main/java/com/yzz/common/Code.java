package com.yzz.common;

/**
 * describe:
 * E-mail:yzzstyle@163.com  date:2019/1/5
 *
 * @Since 0.0.1
 */
public enum Code {
    OK(200,"成功"),
    LOGIN_ID_OR_PASSWORD_ERROR(10001,"用户名或者密码错误")
    ;

    private int code;

    private String msg;

    Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }}
