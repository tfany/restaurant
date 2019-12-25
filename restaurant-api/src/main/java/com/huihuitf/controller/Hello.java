package com.huihuitf.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class Hello {

    @RequestMapping("/hello")
    public String hello(){
        return "big home good";
    }
}
