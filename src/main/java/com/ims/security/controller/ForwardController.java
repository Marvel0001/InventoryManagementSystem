package com.ims.security.controller;

import com.ims.common.service.Impl.StockManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {
    @Autowired
    StockManagementService stockManagementService;
    @RequestMapping("/")
    public String index(){
        System.out.println(stockManagementService.selectAll(1, 1, 1));
        return "Hello";
    }
}
