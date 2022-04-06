package com.ims.security.controller;

import com.ims.common.service.Impl.PeopleManagementService;
import com.ims.common.util.Response;
import com.ims.domain.Admin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Account")
@ResponseBody
public class AccountController {

    @Autowired
    PeopleManagementService peopleManagementService;

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String login(String username, String password){
        Subject subject = SecurityUtils.getSubject();
        Response response = Response.generateResponse();
        System.out.println(username + "  " + password);
        Admin admin;
        try{
            admin = peopleManagementService._selectByUsername(username);
        }catch (Exception e){
            e.printStackTrace();
            response.exception("用户名错误");
            return response.toJSONString();
        }
        if(subject != null){
            if(!subject.isAuthenticated()) {
                UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                try {
                    subject.login(token);
                    response.success();
                    subject.getSession().setAttribute("storehouseId", admin.getStorehouseId().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    response.exception("账号或密码错误");
                }
            }
            else{
                response.exception("已登录，当前登录用户为" + admin.getName());
            }
        }
        else{
            response.exception("登录出错");
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
            response.exception("当前未登录");
        }
        return response.toJSONString();
    }
}
