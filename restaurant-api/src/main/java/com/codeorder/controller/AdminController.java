package com.codeorder.controller;


import com.codeorder.pojo.Admin;
import com.codeorder.service.AdminService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public CommonResult<Object> loginAdmin(@RequestParam(value="UserName") String name,@RequestParam(value="password") String password){
        List<Admin> list=adminService.loginAdmin(name,password);
        return CommonResult.success(list);
    }
}
