package com.ism.security.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/account")
public class AccountController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(String userid, String password){
        Subject subject = SecurityUtils.getSubject();
        JSONObject result = new JSONObject();
        System.out.println(userid + "  " + password);
        if(subject != null && !subject.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(userid, password);
            try {
                subject.login(token);
                result.put("result", "success");
            }catch (Exception e){
                e.printStackTrace();
                result.put("result", "failure");
            }
        }
        else{
            result.put("result", "already login");
        }
        return result.toJSONString();
    }
}
