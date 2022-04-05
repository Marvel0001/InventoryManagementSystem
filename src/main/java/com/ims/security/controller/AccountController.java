package com.ims.security.controller;

import com.ims.common.util.Response;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Account")
@ResponseBody
public class AccountController {

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String login(String userid, String password){
        Subject subject = SecurityUtils.getSubject();
        Response response = Response.generateResponse();
        System.out.println(userid + "  " + password);
        if(subject != null && !subject.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(userid, password);
            try {
                subject.login(token);
                response.success();
            }catch (Exception e){
                e.printStackTrace();
                response.failure();
                response.setData("账号或密码错误");
            }
        }
        else{
            response.failure();
        }
        return response.toJSONString();
    }

    @RequestMapping(value = "/Logout", method = RequestMethod.POST)
    public String Logout(){
        Response response = Response.generateResponse();
        Subject subject = SecurityUtils.getSubject();

        if(subject != null && subject.isAuthenticated()){
            subject.logout();
            response.success();
        }
        else {
            response.failure();
            response.setData("当前未被授权");
        }
        return response.toJSONString();
    }
}
