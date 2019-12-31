package com.codeorder.service.impl;

import com.codeorder.mapper.DishMapper;
import com.codeorder.pojo.Category;
import com.codeorder.pojo.Dish;
import com.codeorder.service.DishService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;

    @Override
    public List<Dish> queryAllDish() {
        return dishMapper.queryAllDish();
    }

    @Override
    public int addDish(Dish dish) {
        return dishMapper.addDish(dish);
    }

    @Override
    public List<Dish> queryDishByCategoryOrId(Integer pageSize, Integer pageNum,Integer id,Integer categoryId) {
        if(pageSize!=null && pageNum!=null){
            PageHelper.startPage(pageNum, pageSize);
        }
        Long total = PageHelper.count(()->dishMapper.queryDishByCategoryId(categoryId));
        if(id == null ){
            if(categoryId !=null){
                System.out.println(total);
                return dishMapper.queryDishByCategoryId(categoryId);
            }
            return null;
        }
        else return dishMapper.queryDishByDishId(id);
    }

    @Override
    public int deleteDish(Integer id) {
        return dishMapper.deleteDishById(id);
    }

    @Override
    public int updateDish(Dish dish) {
        return dishMapper.updateDish(dish);
    }

}
