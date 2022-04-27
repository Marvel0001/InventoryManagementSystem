package com.ims.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
public class ForwardController {
    @RequestMapping(value = {"/login", ""})
    public String index(){
        return "Hello";
    }
}
