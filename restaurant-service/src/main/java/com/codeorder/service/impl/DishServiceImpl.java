package com.codeorder.service.impl;

<<<<<<< HEAD
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
=======
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
>>>>>>> cccc4c4bcd8b991a8a3343f8b903fda8e4bfcb05

@Service
public class DishServiceImpl implements DishService {

<<<<<<< HEAD

=======
>>>>>>> cccc4c4bcd8b991a8a3343f8b903fda8e4bfcb05
    @Autowired
    private DishMapper dishMapper;

    @Override
<<<<<<< HEAD
    public int addDish(Dish dish) {
        if(dishMapper.queryDishByName(dish.name)!=null)
            return 0;
        return dishMapper.addDish(dish);
    }

}
=======
    public Map<String, Object> queryAllDish(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Dish> list = dishMapper.queryAllDish();
        PageInfo<Dish> pageInfo = new PageInfo<>(list);
        return PageUtil.getPageInfo(pageInfo, list);
    }

    @Override
    public int addDish(Dish dish) {
        return dishMapper.addDish(dish);
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
        int res=dishMapper.deleteDishByCategoryId(categoryId);
        return res;
    }

}
>>>>>>> cccc4c4bcd8b991a8a3343f8b903fda8e4bfcb05
