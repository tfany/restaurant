package com.codeorder.service;

import com.codeorder.pojo.Admin;

import java.util.List;

/**
 * 用户登录
 */
public interface AdminService {
    Admin loginAdmin(String name,String password,Integer attribute);
    Admin getAdmin(Integer id);
    int insertAdmin(String name,String password,Integer attribute);

    /**
     * 修改用户密码
     * @param admin
     * @return
     */
    int updatePassword(Admin admin);
}
