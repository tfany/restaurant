package com.codeorder.mapper;

import com.codeorder.my.mapper.MyMapper;
import com.codeorder.pojo.Category;

public interface CategoryMapper extends MyMapper<Category> {


    int addCategory (String categoryName);

    int updateCategory(Category category);

}