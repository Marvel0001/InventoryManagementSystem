package com.ims.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {
    @RequestMapping("mainPage")
    public String mainPage(){
        return "mainPage";
    }
}
