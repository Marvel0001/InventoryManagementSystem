package com.ims.common.controller;

import com.ims.common.service.Interface.StorehouseManagement;
import com.ims.domain.Storehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/StorehouseManagement")
@ResponseBody
@CrossOrigin
public class StorehouseManagementController {
    @Autowired
    StorehouseManagement storehouseManagement;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addStorehouse(Storehouse storehouse){
        return storehouseManagement.addStorehouse(storehouse);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String modifyStorehouse(Storehouse storehouse){
        return storehouseManagement.modifyStorehouse(storehouse);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public String deleteStorehouse(Storehouse storehouse){
        return storehouseManagement.deleteStorehouse(storehouse);
    }
}
