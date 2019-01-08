package com.yzz.user.api;

import com.yzz.user.api.dto.RegisterResponseModel;
import com.yzz.user.api.dto.RejisterRequestModel;

/**
 * describe:
 * E-mail:yzzstyle@163.com  date:2019/1/8
 *
 * @Since 0.0.1
 */
public interface IRegister {

    /**
     * 注册
     * @param request
     * @return
     * @throws Exception
     */
    RegisterResponseModel doRegister(RejisterRequestModel request) throws Exception;


}
