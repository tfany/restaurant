package com.codeorder.service;

import com.codeorder.pojo.Category;

import java.util.Map;

public interface CategoryService {
    int addCategory(String categoryName);
    int deleteCategory(int categoryId);
<<<<<<< HEAD
    //int updateCategory(String categoryName);
=======
    int updateCategory(Category category);
<<<<<<< HEAD
>>>>>>> bde2df733606bf66085d800445a591a4c7475035
=======
    Map<String,Object> categoryList(Integer pageNum,Integer pageSize);
>>>>>>> cccc4c4bcd8b991a8a3343f8b903fda8e4bfcb05
}
