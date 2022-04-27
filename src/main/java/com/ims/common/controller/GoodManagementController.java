package com.ims.common.controller;

import com.ims.common.service.Interface.GoodManagement;
import com.ims.domain.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/GoodManagement")
@ResponseBody
@CrossOrigin
public class GoodManagementController {
    @Autowired
    GoodManagement goodManagement;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addGood(Good good){
        return goodManagement.addGood(good);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String modifyGood(Good good){
        return goodManagement.modifyGood(good);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public String deleteGood(Good good){
        return goodManagement.deleteGood(good);
    }
}
