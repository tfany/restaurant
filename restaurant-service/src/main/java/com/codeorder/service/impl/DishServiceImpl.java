package com.codeorder.service.impl;
import com.codeorder.mapper.CategoryMapper;
import com.codeorder.mapper.DishMapper;
import com.codeorder.pojo.Category;
import com.codeorder.pojo.Dish;
import com.codeorder.pojo.Shop;
import com.codeorder.service.DishService;
import com.codeorder.utils.ImageUtil;
import com.codeorder.utils.PageUtil;
import com.codeorder.utils.PathUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class DishServiceImpl implements DishService {


    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public int addDish(Dish dish) {

        if (dish.getName().trim().isEmpty()||dish.getPrice()==null||dish.getCategoryId()==null||dish.getPrice()<0){     //添加的菜品没有名字或价格或分类
            return -1;
        }
        if(categoryMapper.getCategoryById(dish.getCategoryId())==null){
            return -2;
        }
        List<Dish> result = dishMapper.queryDishByName(dish.getName().replace(" ",""));
        if(result.size()!=0)          //菜单中已有该菜品
            return 0;
        int res= dishMapper.addDish(dish);
        setImage(dish.getPicture(),dish.getName());
        return res;

    }

    public void setImage(String path,String name){
        Dish dish = dishMapper.queryDishByName(name).get(0);
        Integer id=dish.getId();
        String dishPath= PathUtil.getDishImagePath(id.toString());
        try {
            String result = ImageUtil.generateThumbnail(PathUtil.getCommonsMult(PathUtil.getImgBasePath()+path),dishPath);
            dish.setPicture(result);
            updateDish(dish);
            PathUtil.deleteDir(PathUtil.getImgBasePath()+"dish/-999/");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        PathUtil.deleteDir(PathUtil.getImgBasePath()+"dish/"+id);
        return dishMapper.deleteDishById(id);
    }

    @Override
    public int updateDish(Dish dish) {
        if (dish.getName().trim().isEmpty()||dish.getPrice()==null||dish.getCategoryId()==null||dish.getPrice()<0){     //更新的菜品没有名字或价格或分类
            return -1;
        }
        if(categoryMapper.getCategoryById(dish.getCategoryId())==null){
            return -2;
        }
        List<Dish> result = dishMapper.queryDishByName(dish.getName());
        if(result.size()!=0&&result.get(0).getId()!=dish.getId())          //菜单中已有该菜品
            return 0;
        PathUtil.deleteFiles(dish.getPicture());
        return dishMapper.updateDish(dish);
    }

    @Override

    public Dish queryDishById(Integer id) {
        return dishMapper.selectByPrimaryKey(id);
    }

    public int deleteByCategoryId(Integer categoryId) {
        return dishMapper.deleteDishByCategoryId(categoryId);
    }

    @Override
    public List<Dish> queryDishByCategoryId(Integer categoryId) {
        return dishMapper.queryDishByCategoryId(categoryId);
    }

    @Override
    public List<Dish> queryAllDishNoPage()
    {
        return dishMapper.queryAllDish();
    }

}

