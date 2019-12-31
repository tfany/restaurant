package com.codeorder.controller;


import com.codeorder.pojo.Admin;
import com.codeorder.service.AdminService;
import com.codeorder.utils.CommonResult;
import com.codeorder.utils.CookieUtils;
import com.codeorder.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping ("/login")
    public CommonResult<Object> loginAdmin(@RequestParam(value="UserName") String name, @RequestParam(value="password") String password, @RequestParam(value = "attribute")Integer attribute, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(name!=null&&password!=null&&attribute!=null) {
            Admin admin = adminService.loginAdmin(name, MD5Utils.getMD5Str(password),attribute);
            if (admin != null) {
                CookieUtils.setCookie(request,response,"sessionId",admin.getId().toString());
                return CommonResult.success(admin);
            } else {
                return CommonResult.failed("用户名或密码错误");
            }
        }
        return CommonResult.failed("用户名或密码错误");
    }

    @PostMapping("/loginout")
    public CommonResult<Object> loginoutAdmin(HttpServletRequest request,HttpServletResponse response){
        CookieUtils.deleteCookie(request,response,"sessionId");
        return CommonResult.success("已退出");
    }

    @PostMapping("/insertAdminInner")
    public CommonResult<Object> insertAdmin(@RequestParam(value="UserName") String name, @RequestParam(value="password") String password, @RequestParam(value = "attribute")Integer attribute) throws Exception {

        Integer result=adminService.insertAdmin(name,MD5Utils.getMD5Str(password),attribute);
        if(result==1) {
            return CommonResult.success(result);
        }
        return CommonResult.failed("添加失败");
    }
}
