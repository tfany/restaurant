package com.codeorder.mapper;

import com.codeorder.my.mapper.MyMapper;
import com.codeorder.pojo.Category;

public interface CategoryMapper extends MyMapper<Category> {
    int updateCategory(Category category);
    Category getCategoryById(Integer categoryId);
    Category queryCategoryByName(String categoryName);
}