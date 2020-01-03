package com.codeorder.mapper;

import com.codeorder.my.mapper.MyMapper;
import com.codeorder.pojo.Desk;
import org.apache.ibatis.annotations.Param;

public interface DeskMapper extends MyMapper<Desk> {
    int insertDesk(@Param("deskNum") int deskNum, @Param("url") String url);

}
