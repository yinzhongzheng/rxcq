package com.yzz.view.oa.controller;

import com.yzz.common.Code;
import com.yzz.view.oa.controller.support.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qingyin
 * @date 2016/8/21
 */
public class BaseController {
    public Logger LOG = LoggerFactory.getLogger(BaseController.class);


    protected String redirectTo(String url) {
        StringBuffer rto = new StringBuffer("redirect:");
        rto.append(url);
        return rto.toString();
    }

    protected ResponseData setEnumResult(Code code, Object data) {
        ResponseData res = new ResponseData();
        res.setStatus(code.getCode());
        res.setData(null == data ? "empty" : data);
        res.setMessage(code.getMsg());
        return res;
    }
}
