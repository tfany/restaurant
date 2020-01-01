package com.codeorder.service;

import com.codeorder.pojo.Dish;

import java.util.List;
import java.util.Map;

public interface DishService {

    Map<String,Object> queryAllDish(int pageNum, int pageSize);

    int addDish(Dish dish);

    List<Dish> queryDishByCategoryOrName(Integer pageSize,Integer pageNum,String name,Integer categoryId);

    int deleteDish(Integer id);

    int updateDish(Dish dish);

}
