package com.codeorder.mapper;

import com.codeorder.my.mapper.MyMapper;
import com.codeorder.pojo.Category;

import java.util.List;

public interface CategoryMapper extends MyMapper<Category> {
    int updateCategory(Category category);
    Category getCategoryById(Integer categoryId);

    /**
     * 查询所有的种类
     * @return
     */
    List<Category> queryAllCategory();
    Category queryCategoryByName(String categoryName);
}