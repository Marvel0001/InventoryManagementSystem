package com.ims.common.controller;

import com.ims.common.service.Impl.GoodManagementService;
import com.ims.domain.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/GoodManagement")
@ResponseBody
public class GoodManagementController {
    @Autowired
    GoodManagementService goodManagementService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addGood(Good good){
        return goodManagementService.addGood(good);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String modifyGood(Good good){
        return goodManagementService.modifyGood(good);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public String deleteGood(Good good){
        return goodManagementService.deleteGood(good);
    }
}
