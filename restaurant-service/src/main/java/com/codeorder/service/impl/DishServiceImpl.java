package com.codeorder.service.impl;

import com.codeorder.mapper.CategoryMapper;
import com.codeorder.mapper.DishMapper;
import com.codeorder.pojo.Category;
import com.codeorder.pojo.Dish;
import com.codeorder.service.CategoryService;
import com.codeorder.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {


    @Autowired
    private DishMapper dishMapper;

    @Override
    public int addDish(Dish dish) {
        if(dishMapper.queryDishByName(dish.name)!=null)
            return 0;
        return dishMapper.addDish(dish);
    }

}