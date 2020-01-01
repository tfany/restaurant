package com.codeorder.service.impl;

import com.codeorder.mapper.CategoryMapper;
import com.codeorder.pojo.Category;
import com.codeorder.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public int addCategory(Category category) {
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
}
