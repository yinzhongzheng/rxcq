package com.yzz.user.api.dto;

import java.io.Serializable;

/**
 * describe:
 * E-mail:yzzstyle@163.com  date:2019/1/5
 *
 * @Since 0.0.1
 */
public class LoginModel implements Serializable {

    private static final long serialVersionUID = 9010232202614250292L;

    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
