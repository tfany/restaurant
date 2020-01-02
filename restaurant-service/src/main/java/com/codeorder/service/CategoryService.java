package com.codeorder.service;

import com.codeorder.pojo.Category;

public interface CategoryService {
    int addCategory(String categoryName);
    int deleteCategory(int categoryId);
    //int updateCategory(String categoryName);
}
