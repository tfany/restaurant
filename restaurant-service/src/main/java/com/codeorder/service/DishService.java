package com.codeorder.service;

<<<<<<< HEAD
import com.codeorder.pojo.Category;
import com.codeorder.pojo.Dish;

import java.util.List;

public interface DishService {
    int addDish(Dish dish);
    //int deleteDish(int DishId);
=======
import com.codeorder.pojo.Dish;

import java.util.List;
import java.util.Map;

public interface DishService {

    Map<String,Object> queryAllDish(int pageNum, int pageSize);

    int addDish(Dish dish);

    Map<String,Object> queryDishByCategoryOrName(Integer pageNum,Integer pageSize,String name,Integer categoryId);

    int deleteDish(Integer id);

    int updateDish(Dish dish);


    Dish queryDishById(Integer id);

    int deleteByCategoryId(Integer categoryId);


>>>>>>> cccc4c4bcd8b991a8a3343f8b903fda8e4bfcb05
}
