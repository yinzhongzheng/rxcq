package com.yzz.user.api.dto;


import com.yzz.common.Code;

import java.io.Serializable;

/**
 * describe:
 * E-mail:yzzstyle@163.com  date:2019/1/8
 *
 * @Since 0.0.1
 */
public class RegisterResponseModel implements Serializable {
    private static final long serialVersionUID = 297081545103788238L;

    private Code code;

    private String userId;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RegisterResponseModel{" +
                "code=" + code +
                ", userId='" + userId + '\'' +
                '}';
    }
}
