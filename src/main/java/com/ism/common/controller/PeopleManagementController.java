package com.ism.common.controller;

import com.ism.common.service.Impl.PeopleManagementService;
import com.ism.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/PeopleManagement")
@ResponseBody
public class PeopleManagementController {
    @Autowired
    private PeopleManagementService peopleManagementService;

    @RequestMapping("/AddAdmin")
    public String addAdmin(Admin admin){
        return peopleManagementService.addAdmin(admin);
    }
}
