package com.codeorder.service;

import com.codeorder.pojo.Admin;

import java.util.List;

/**
 * 用户登录
 */
public interface AdminService {
    Admin loginAdmin(String name,String password,Integer limit);
}
