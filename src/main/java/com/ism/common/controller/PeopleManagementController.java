package com.ism.common.controller;

import com.ism.common.service.Impl.PeopleManagementService;
import com.ism.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/PeopleManagement")
@ResponseBody
public class PeopleManagementController {
    @Autowired
    private PeopleManagementService peopleManagementService;

    final String SELECT_BY_ID = "selectById";
    final String SELECT_BY_STOREHOUSE_ID = "selectByStorehouseId";
    final String SELECT_BY_NAME = "selectByName";
    final String SELECT_ALL = "selectAll";

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addAdmin(Admin admin){
        return peopleManagementService.addAdmin(admin);
    }

    public String _Select(String type, String param, Integer offset, Integer limit){
        String result;
        System.out.println(offset + " " + limit);
        switch(type){
            case SELECT_ALL:
                result = peopleManagementService.selectAllAdmin(offset, limit);
                break;
            case SELECT_BY_ID:
                result = peopleManagementService.selectAdminById(Integer.valueOf(param));
                break;
            case SELECT_BY_NAME:
                result = peopleManagementService.selectAdminByName(param, offset, limit);
                break;
            case SELECT_BY_STOREHOUSE_ID:
                result = peopleManagementService.selectAdminByStorehouseId(Integer.valueOf(param), offset, limit);
                break;
            default:
                result = "{\"result\":\"failure\", \"data\": \"select type error\"}";
                break;
        }
        return result;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Select(String type, String param, Integer offset, Integer limit){
        return _Select(type, param, offset, limit);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String Modify(Admin admin){
        return peopleManagementService.modifyAdmin(admin);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public String Delete(Admin admin){
        return peopleManagementService.deleteAdmin(admin);
    }
}
