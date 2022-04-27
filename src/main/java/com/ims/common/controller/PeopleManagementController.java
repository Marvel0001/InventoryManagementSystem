package com.ims.common.controller;

import com.ims.common.service.Interface.PeopleManagement;
import com.ims.common.util.Response;
import com.ims.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/PeopleManagement")
@ResponseBody
@CrossOrigin
public class PeopleManagementController {
    @Autowired
    private PeopleManagement peopleManagement;

    final String SELECT_BY_ID = "selectById";
    final String SELECT_BY_STOREHOUSE_ID = "selectByStorehouseId";
    final String SELECT_BY_NAME = "selectByName";
    final String SELECT_ALL = "selectAll";

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addAdmin(Admin admin){
        return peopleManagement.addAdmin(admin);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Select(String type, String param, Integer offset, Integer limit){
        try {
            switch (type) {
                case SELECT_ALL:
                    return peopleManagement.selectAllAdmin(offset, limit);
                case SELECT_BY_ID:
                    return peopleManagement.selectAdminById(Integer.valueOf(param));
                case SELECT_BY_NAME:
                    return peopleManagement.selectAdminByName(param, offset, limit);
                case SELECT_BY_STOREHOUSE_ID:
                    return peopleManagement.selectAdminByStorehouseId(Integer.valueOf(param), offset, limit);
                default:
                    return Response._default();
            }
        }catch (NumberFormatException e){
            return Response._exception("参数错误");
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String Modify(Admin admin){
        return peopleManagement.modifyAdmin(admin);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public String Delete(Admin admin){
        return peopleManagement.deleteAdmin(admin);
    }
}
