package com.codeorder.service;

import com.codeorder.pojo.Category;

public interface CategoryService {
    int addCategory(String categoryName);
    int deleteCategory(int categoryId);
<<<<<<< HEAD
    //int updateCategory(String categoryName);
=======
    int updateCategory(Category category);
>>>>>>> bde2df733606bf66085d800445a591a4c7475035
}
