package com.codeorder.service.impl;
import com.codeorder.mapper.DishMapper;
import com.codeorder.pojo.Dish;
import com.codeorder.service.DishService;
import com.codeorder.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DishServiceImpl implements DishService {


    @Autowired
    private DishMapper dishMapper;

    @Override
    public int addDish(Dish dish) {
        if(dishMapper.queryDishByName(dish.getName())!=null)
            return 0;
        return dishMapper.addDish(dish);
    }


    public Map<String, Object> queryAllDish(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Dish> list = dishMapper.queryAllDish();
        PageInfo<Dish> pageInfo = new PageInfo<>(list);
        return PageUtil.getPageInfo(pageInfo, list);
    }


    @Override
    public Map<String, Object> queryDishByCategoryOrName(Integer pageNum, Integer pageSize, String name, Integer categoryId) {
        if(name==null && categoryId==null)
        {
            return queryAllDish(pageNum,pageSize);
        }
        PageHelper.startPage(pageNum, pageSize);

        List<Dish> list = dishMapper.queryDishByCategoryAndName(categoryId, name);
        PageInfo<Dish> pageInfo=new PageInfo<>(list);
        return PageUtil.getPageInfo(pageInfo,list);
    }

    @Override
    public int deleteDish(Integer id) {
        return dishMapper.deleteDishById(id);
    }

    @Override
    public int updateDish(Dish dish) {
        return dishMapper.updateDish(dish);
    }

    @Override

    public Dish queryDishById(Integer id) {
        return dishMapper.selectByPrimaryKey(id);
    }

    public int deleteByCategoryId(Integer categoryId) {
        return dishMapper.deleteDishByCategoryId(categoryId);
    }

}

