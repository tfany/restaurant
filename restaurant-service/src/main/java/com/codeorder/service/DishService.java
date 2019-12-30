package com.codeorder.service;

import com.codeorder.pojo.Dish;

import java.util.List;

public interface DishService {

    List<Dish> queryAllDish();

    int addDish(Dish dish);

    List<Dish> queryDishByCategoryOrId(Integer pageSize,Integer pageNum,Integer id,Integer categoryId);

    int deleteDish(Integer id);

    int updateDish(Dish dish);

}
