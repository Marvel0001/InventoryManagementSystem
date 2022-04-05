package com.ims.common.controller;

import com.ims.common.service.Impl.PeopleManagementService;
import com.ims.common.util.Response;
import com.ims.domain.Admin;
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
        try {
            switch (type) {
                case SELECT_ALL:
                    return peopleManagementService.selectAllAdmin(offset, limit);
                case SELECT_BY_ID:
                    return peopleManagementService.selectAdminById(Integer.valueOf(param));
                case SELECT_BY_NAME:
                    return peopleManagementService.selectAdminByName(param, offset, limit);
                case SELECT_BY_STOREHOUSE_ID:
                    return peopleManagementService.selectAdminByStorehouseId(Integer.valueOf(param), offset, limit);
                default:
                    return Response._default();
            }
        }catch (NumberFormatException e){
            return Response._exception("参数错误");
        }
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
