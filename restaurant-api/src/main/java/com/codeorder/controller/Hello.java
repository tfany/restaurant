package com.codeorder.controller;

import com.codeorder.utils.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class Hello {

    @RequestMapping("/hello")
    public CommonResult<List<String>> hello(){
        List<String> list=new ArrayList<>();
        list.add("111");
        list.add("112");
        list.add("113");
        list.add("115");
        list.add("114");
        list.add("115");
        return CommonResult.success(list);
    }


}
