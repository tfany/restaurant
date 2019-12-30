package com.codeorder.controller;


import com.codeorder.pojo.Admin;
import com.codeorder.service.AdminService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping ("/login")
    public CommonResult<Object> loginAdmin(@RequestParam(value="UserName") String name,@RequestParam(value="password") String password,@RequestParam(value = "limit")Integer limit){
        Admin admin=adminService.loginAdmin(name,password,limit);
        if(admin!=null){
            return CommonResult.success(admin);
        }else {
            return CommonResult.failed("用户名或密码错误");
        }
    }
}
