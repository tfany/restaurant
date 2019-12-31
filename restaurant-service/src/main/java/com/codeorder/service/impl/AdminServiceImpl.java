package com.codeorder.service.impl;

import com.codeorder.mapper.AdminMapper;
import com.codeorder.pojo.Admin;
import com.codeorder.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin loginAdmin(String name,String password,Integer attribute) {

        return  adminMapper.queryAdmin(name,password,attribute);
    }

    @Override
    public int insertAdmin(String name, String password, Integer attribute) {
        return  adminMapper.insertAdmin(name,password,attribute);
    }
}
