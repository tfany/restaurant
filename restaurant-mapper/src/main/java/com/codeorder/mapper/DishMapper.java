package com.codeorder.mapper;

import com.codeorder.my.mapper.MyMapper;
import com.codeorder.pojo.Dish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DishMapper extends MyMapper<Dish> {

    List<Dish> queryAllDish();

    List<Dish> queryDishByCategoryId(@Param("categoryId") Integer categoryId);

    List<Dish> queryDishByDishId(@Param("id")Integer id);

    int addDish(Dish dish);

    int deleteDishById(@Param("id")Integer id);

    int updateDish(Dish dish);

}