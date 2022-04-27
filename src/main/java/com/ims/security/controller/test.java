package com.ims.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
public class test {
    @RequestMapping("mainPage")
    public String mainPage(){
        return "mainPage";
    }

    @RequestMapping("unauthorized")
    public String unauthorized(){ return "unauthorized";}
}
