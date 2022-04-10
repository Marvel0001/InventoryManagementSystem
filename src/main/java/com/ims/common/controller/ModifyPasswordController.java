package com.ims.common.controller;

import com.ims.common.service.Interface.PeopleManagement;
import com.ims.common.util.Response;
import com.ims.domain.Admin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ModifyPassword")
@ResponseBody
public class ModifyPasswordController {
    @Autowired
    PeopleManagement peopleManagement;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String modifyPassword(String oldPassword, String newPassword){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Response response = Response.generateResponse();
        Admin admin = new Admin();
        if(session.getAttribute("password").toString().equals(oldPassword)) {
            admin.setPassword(newPassword);
            admin.setId(Integer.valueOf(session.getAttribute("userId").toString()));
            try {
                peopleManagement.modifyAdmin(admin);
                response.success();
            } catch (Exception e) {
                response.exception("修改密码失败");
            }
        }
        else{
            response.exception("原密码错误，如果忘记请找管理员修改");
        }
        return response.toJSONString();
    }

}
