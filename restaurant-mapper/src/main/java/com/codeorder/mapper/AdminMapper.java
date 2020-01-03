package com.codeorder.mapper;

import com.codeorder.my.mapper.MyMapper;
import com.codeorder.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 查询输入的用户名和密码是否和数据库匹配；
 *      如果匹配，返回查询到的结果
 */
public interface AdminMapper extends MyMapper<Admin> {
    Admin queryAdmin(@Param("name") String Name,@Param("password") String Password,@Param("attribute")Integer attribute);
    int insertAdmin(@Param("name") String Name,@Param("password") String Password,@Param("attribute")Integer attribute);

    int updatePassword(Admin admin);

    List<Admin> queryAdminById(@Param("id")Integer id);
}