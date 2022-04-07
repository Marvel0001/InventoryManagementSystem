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
public class StorehouseManagementController {
    @Autowired
    StorehouseManagementService storehouseManagementService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addStorehouse(Storehouse storehouse){
        return storehouseManagementService.addStorehouse(storehouse);
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
