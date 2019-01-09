package com.yzz.view.oa.controller;


import com.yzz.common.Code;
import com.yzz.user.api.ILogin;
import com.yzz.user.api.dto.LoginModel;
import com.yzz.view.oa.controller.support.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@Controller
@RequestMapping("/index/")
public class IndexController extends BaseController {

    @Autowired
    private ILogin login;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return "/login";
        }
        return "/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {


        return "/login";
    }

    @RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData submitLogin(HttpServletRequest request, String loginname, String password) {
        LoginModel loginModel = new LoginModel();
        loginModel.setName(loginname);
        loginModel.setPassword(password);
        Code code = login.login(loginModel);
        request.getSession().setAttribute("user","root");
        return setEnumResult(code, "/");
    }

    /**
     * 退出
     *
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        try {
            request.getSession().removeAttribute("user");
        } catch (Exception e) {
            LOG.error("errorMessage:" + e.getMessage());
        }
        return redirectTo("/index/login.shtml");
    }
}
