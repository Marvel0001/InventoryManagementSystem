package com.ims.security.controller;

import com.ims.common.service.Interface.StockManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {
    @Autowired
    StockManagement stockManagement;
    @RequestMapping(value = {"/login", ""})
    public String index(){
        System.out.println(stockManagement.selectAll(1, 1, 1));
        return "Hello";
    }
}
