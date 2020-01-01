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
    public Map<String, Object> queryAllDish(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Dish> list=dishMapper.queryAllDish();
        PageInfo<Dish> pageInfo=new PageInfo<>(list);
        return PageUtil.getPageInfo(pageInfo,list);
    }

    @Override
    public int addDish(Dish dish) {
        return dishMapper.addDish(dish);
    }

    //TODO 模糊查询 联合查询
    @Override
    public List<Dish> queryDishByCategoryOrName(Integer pageSize, Integer pageNum,String name,Integer categoryId) {
        if(pageSize!=null && pageNum!=null){
            PageHelper.startPage(pageNum, pageSize);
        }
        Long total = PageHelper.count(()->dishMapper.queryDishByCategoryId(categoryId));
        if(name == null ){
            if(categoryId !=null){
                System.out.println(total);
                return dishMapper.queryDishByCategoryId(categoryId);
            }
            return null;
        }
        else return dishMapper.queryDishByDishName(name);
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
