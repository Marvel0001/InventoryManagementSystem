package com.ims.common.controller;

import com.ims.common.service.Impl.StorehouseManagementService;
import com.ims.common.util.Response;
import com.ims.domain.Storehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/StorehouseManagement")
@ResponseBody
public class StorehouseManagement {
    @Autowired
    StorehouseManagementService storehouseManagementService;

    final String SELECT_BY_ID = "selectById";
    final String SELECT_BY_REGION = "selectByRegion";
    final String SELECT_ENABLED = "selectEnabled";
    final String SELECT_DISABLED = "selectDisabled";
    final String SELECT_ALL = "selectAll";

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addStorehouse(Storehouse storehouse){
        return storehouseManagementService.addStorehouse(storehouse);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String selectStorehouse(String type, String param, Integer offset, Integer limit){
        try {
            switch (type) {
                case SELECT_ALL:
                    return storehouseManagementService.selectAllStorehouse(offset, limit);
                case SELECT_BY_ID:
                    return storehouseManagementService.selectStorehouseById(Integer.valueOf(param));
                case SELECT_BY_REGION:
                    return storehouseManagementService.selectStorehouseByRegion(param, offset, limit);
                case SELECT_ENABLED:
                    return storehouseManagementService.selectStorehouseEnabled(offset, limit);
                case SELECT_DISABLED:
                    return storehouseManagementService.selectStorehouseDisabled(offset, limit);
                default:
                    return Response._default();
            }
        }catch (NumberFormatException e){
            return Response._exception("格式错误");
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String modifyStorehouse(Storehouse storehouse){
        return storehouseManagementService.modifyStorehouse(storehouse);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public String deleteStorehouse(Storehouse storehouse){
        return storehouseManagementService.deleteStorehouse(storehouse);
    }
}
