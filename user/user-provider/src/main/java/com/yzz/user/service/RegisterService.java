package com.yzz.user.service;

import com.yzz.user.api.IRegister;
import com.yzz.user.api.dto.RegisterResponseModel;
import com.yzz.user.api.dto.RejisterRequestModel;
import org.springframework.stereotype.Service;

/**
 * describe:
 * E-mail:yzzstyle@163.com  date:2019/1/8
 *
 * @Since 0.0.1
 */
@Service(value = "registerService")
public class RegisterService implements IRegister {

    @Override
    public RegisterResponseModel doRegister(RejisterRequestModel request) throws Exception {
        //数据库插入

        //插入

        return null;
    }


}
