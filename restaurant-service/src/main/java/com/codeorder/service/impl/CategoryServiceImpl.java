package com.codeorder.service.impl;

import com.codeorder.mapper.CategoryMapper;
import com.codeorder.mapper.DishMapper;
import com.codeorder.pojo.Category;
import com.codeorder.pojo.CategoryDto;
import com.codeorder.pojo.Dish;
import com.codeorder.service.CategoryService;
import com.codeorder.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private DishMapper dishMapper;

    @Override
    public int addCategory(String categoryName) {
        if (categoryName.trim().isEmpty()){     //添加的分类名字
            return -1;
        }
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", categoryName);
        int count = categoryMapper.selectCountByExample(example);
        if (count > 0) {
            return 0;
        }
        Category category = new Category();
        category.setName(categoryName);
        return categoryMapper.insert(category);
    }

    @Override
    public int deleteCategory(int categoryId) {
        Category category=categoryMapper.selectByPrimaryKey(categoryId);
        if(category==null){
            return 0;
        }
        int res=categoryMapper.delete(category);
        return res;
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryMapper.getCategoryById(categoryId);
    }

    @Override
    public List<Category> queryAllCategory() {
        return categoryMapper.queryAllCategory();
    }


    //@Override
    //public int updateCategory(String categoryName){

    //}



    @Override
    public int updateCategory(Category category) {
        if (category.getName().trim().isEmpty()){     //添加的分类名字
            return -1;
        }
        if (categoryMapper.getCategoryById(category.getId())==null){     //添加的分类名字
            return -2;
        }
        Category category1 = categoryMapper.queryCategoryByName(category.getName());
        if(category1!=null&&category1.getId()!=category.getId()) {
            return 0;
        }
        return categoryMapper.updateCategory(category);
    }



    @Override
    public Map<String, Object> categoryList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Category> list = categoryMapper.selectAll();
        List<CategoryDto> countList=new ArrayList<>();
        for (Category category : list) {
            int id = category.getId();
            Example example = new Example(Dish.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("categoryId", id);
            int count=dishMapper.selectCountByExample(example);
            countList.add(new CategoryDto(id, category.getName(),count));
        }
        PageInfo<Category> pageInfo = new PageInfo<>(list);
        return PageUtil.getPageInfo(pageInfo, countList);
    }

}
