package com.codeorder.utils;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtil {
    public static Map<String,Object> getPageInfo(PageInfo pageInfo, List list){

        Map<String, Object> map=new HashMap<>();
        map.put("list",list);
        map.put("pageNum",pageInfo.getPageNum());
        map.put("pageSize",pageInfo.getPageSize());
        map.put("total",pageInfo.getTotal());
        map.put("totalPage",pageInfo.getPages());
        return map;
    }
}
