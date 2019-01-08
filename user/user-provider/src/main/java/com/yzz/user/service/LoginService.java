package com.yzz.user.service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.yzz.common.Code;
import com.yzz.user.api.ILogin;
import com.yzz.user.api.dto.LoginModel;
import org.springframework.stereotype.Service;

/**
 * describe:
 * E-mail:yzzstyle@163.com  date:2019/1/5
 *
 * @Since 0.0.1
 */

@Service(value = "loginService")
public class LoginService implements ILogin {


    @Override
    public Code login(LoginModel loginModel) {
        String name = loginModel.getName();
        String password = loginModel.getPassword();
        if (StringUtils.isEquals("root", name) && StringUtils.isEquals("root", password)) {
            //成功
            return Code.OK;
        }
        return Code.LOGIN_ID_OR_PASSWORD_ERROR;
    }

    @Override
    public Code loginOut(LoginModel loginModel) {

        return null;
    }
}
