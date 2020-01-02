package com.codeorder.service;


import com.codeorder.pojo.Category;
import com.codeorder.pojo.Dish;

import java.util.List;
import java.util.Map;

public interface DishService {
    int addDish(Dish dish);
    //int deleteDish(int DishId);

    Map<String,Object> queryAllDish(int pageNum, int pageSize);


    Map<String,Object> queryDishByCategoryOrName(Integer pageNum, Integer pageSize, String name, Integer categoryId);

    int deleteDish(Integer id);

    int updateDish(Dish dish);


    Dish queryDishById(Integer id);

    int deleteByCategoryId(Integer categoryId);


}
