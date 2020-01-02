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
<<<<<<< HEAD

    Admin queryAdmin(@Param("Name") String Name,@Param("Password") String Password,@Param("Limit")Integer Limit);
=======
    Admin queryAdmin(@Param("Name") String Name,@Param("Password") String Password,@Param("attribute")Integer attribute);
    int insertAdmin(@Param("Name") String Name,@Param("Password") String Password,@Param("attribute")Integer attribute);
>>>>>>> cccc4c4bcd8b991a8a3343f8b903fda8e4bfcb05
}