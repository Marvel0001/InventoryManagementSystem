package com.ims.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {
    @RequestMapping(value = {"/login", ""})
    public String index(){
        return "Hello";
    }
}
