package com.codeorder.mapper;

import com.codeorder.my.mapper.MyMapper;
import com.codeorder.pojo.Shop;

import java.util.List;

public interface ShopMapper extends MyMapper<Shop> {
    List<Shop> shopInfo() ;
    int updateByPrimaryKey(Shop shop );
}