package com.codeorder.service;

import com.codeorder.pojo.Category;

public interface CategoryService {
    int addCategory(Category category);
    int deleteCategory(int categoryId);
}
