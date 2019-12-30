package com.codeorder.mapper;

import com.codeorder.my.mapper.MyMapper;
import com.codeorder.pojo.Category;
import com.codeorder.pojo.Dish;
import com.codeorder.pojo.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DishMapper extends MyMapper<Dish> {
    Shop queryShop();
}