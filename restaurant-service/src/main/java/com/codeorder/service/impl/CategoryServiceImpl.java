package com.codeorder.service.impl;

import com.codeorder.mapper.CategoryMapper;
import com.codeorder.pojo.Category;
import com.codeorder.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public int addCategory(String categoryName) {
        Example example=new Example(Category.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("name",categoryName);
        int count = categoryMapper.selectCountByExample(example);
        if(count>0){
            return 0;
        }
        Category category=new Category();
        category.setName(categoryName);
        return categoryMapper.insert(category);
    }

    @Override
    public int deleteCategory(int categoryId) {
        return categoryMapper.deleteByPrimaryKey(categoryId);
    }
}
