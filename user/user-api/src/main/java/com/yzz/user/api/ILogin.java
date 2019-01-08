package com.yzz.user.api;

import com.yzz.common.Code;
import com.yzz.user.api.dto.LoginModel;

/**
 * describe:
 * E-mail:yzzstyle@163.com  date:2019/1/5
 *
 * @Since 0.0.1
 */
public interface ILogin {

    Code login(LoginModel loginModel);

    Code loginOut(LoginModel loginModel);
}
