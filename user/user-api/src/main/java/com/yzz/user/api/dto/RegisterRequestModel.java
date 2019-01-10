package com.yzz.user.api.dto;

import java.io.Serializable;

/**
 * describe:
 * E-mail:yzzstyle@163.com  date:2019/1/8
 *
 * @Since 0.0.1
 */
public class RegisterRequestModel implements Serializable {

    private static final long serialVersionUID = 3835405628050047790L;

    private String name;

    private String password;

    private String  registerWay;

    private String doRegisterAccount;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterWay() {
        return registerWay;
    }

    public void setRegisterWay(String registerWay) {
        this.registerWay = registerWay;
    }

    public String getDoRegisterAccount() {
        return doRegisterAccount;
    }

    public void setDoRegisterAccount(String doRegisterAccount) {
        this.doRegisterAccount = doRegisterAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RejisterRequestModel{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", registerWay='" + registerWay + '\'' +
                ", doRegisterAccount='" + doRegisterAccount + '\'' +
                '}';
    }
}
