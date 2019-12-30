package com.codeorder.mapper;

import com.codeorder.my.mapper.MyMapper;
import com.codeorder.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 查询输入的用户名和密码是否和数据库匹配；
 *      如果匹配，返回查询到的所有结果
 */
public interface AdminMapper extends MyMapper<Admin> {
    List<Admin> selAdmin(@Param("Name") String Name,@Param("Password") String Password);
}