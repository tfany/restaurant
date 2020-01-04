package com.codeorder.service;

import com.codeorder.pojo.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    int addCategory(String categoryName);
    int deleteCategory(int categoryId);
    int updateCategory(Category category);
    Map<String,Object> categoryList(Integer pageNum,Integer pageSize);
    Category getCategoryById(int categoryId);
}
