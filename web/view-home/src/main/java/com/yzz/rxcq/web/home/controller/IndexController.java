package com.yzz.rxcq.web.home.controller;

import com.yzz.common.Code;
import com.yzz.rxcq.web.home.controller.support.ResponseData;
import com.yzz.rxcq.web.home.controller.support.ResponseEnum;
import com.yzz.user.api.IRegister;
import com.yzz.user.api.dto.RegisterRequestModel;
import com.yzz.user.api.dto.RegisterResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
@Controller
public class IndexController {

    @Autowired
    IRegister userRegister;

    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping("/index")
    public String index(Model model) {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public @ResponseBody
    ResponseData register(String username, String password, String mobile) {
        ResponseData data = new ResponseData();

        RegisterRequestModel request = new RegisterRequestModel();
        request.setRegisterWay("phone");
        request.setDoRegisterAccount(mobile);
        request.setPassword(password);
        try {
            RegisterResponseModel response = userRegister.doRegister(request);
            if (response.getCode() == Code.OK) {
                //发送邮件  发送卡券
                jmsTemplate.send(session -> session.createTextMessage("发送邮件"));
            }
            data.setMessage(response.getCode().getMsg());
            data.setCode(String.valueOf(response.getCode().getCode()));
        } catch (Exception e) {
            data.setMessage(ResponseEnum.FAILED.getMsg());
            data.setCode(ResponseEnum.FAILED.getCode());
        }
        return data;
    }
}
