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

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping ("/login")
    public CommonResult<Object> loginAdmin(@RequestBody Admin loginAdmin, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(loginAdmin.getName()!=null&&loginAdmin.getPassword()!=null&&loginAdmin.getAttribute()!=null) {
            Admin admin = adminService.loginAdmin(loginAdmin.getName(), MD5Utils.getMD5Str(loginAdmin.getPassword()),loginAdmin.getAttribute());
            if (admin != null) {
                CookieUtils.setCookie(request, response, "sessionId",
                        String.valueOf(admin.getId()), true);
                return CommonResult.success(admin);
            } else {
                return CommonResult.failed("用户名或密码错误");
            }
        }
        return CommonResult.failed("用户名或密码错误");
    }

    @PostMapping("/loginOut")
    public CommonResult<Object> loginOutAdmin(HttpServletRequest request,HttpServletResponse response){
        CookieUtils.deleteCookie(request,response,"sessionId");
        return CommonResult.success("已退出");
    }

    @PostMapping("/insertAdminInner")
    public CommonResult<Object> insertAdmin(@RequestParam(value="userName") String name, @RequestParam(value="password") String password, @RequestParam(value = "attribute")Integer attribute) throws Exception {

        int result=adminService.insertAdmin(name,MD5Utils.getMD5Str(password),attribute);
        if(result==1) {
            return CommonResult.success(result);
        }
        return CommonResult.failed("添加失败");
    }

    @GetMapping("info")
    public CommonResult<Admin> getInfo(HttpServletRequest request,HttpServletResponse response){
        return CommonResult.success(null);
    }


}
