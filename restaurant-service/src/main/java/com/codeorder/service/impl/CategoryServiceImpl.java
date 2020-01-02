package com.codeorder.service.impl;

import com.codeorder.mapper.CategoryMapper;
import com.codeorder.pojo.Category;
import com.codeorder.service.CategoryService;
import com.codeorder.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public int addCategory(String categoryName) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", categoryName);
        int count = categoryMapper.selectCountByExample(example);
        if (count > 0) {
            return 0;
        }
        Category category = new Category();
        category.setName(categoryName);
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

    //@Override
    //public int updateCategory(String categoryName){

    //}


    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }


    @Override
    public Map<String, Object> categoryList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Category> list = categoryMapper.selectAll();
        PageInfo<Category> pageInfo = new PageInfo<>(list);
        return PageUtil.getPageInfo(pageInfo, list);
    }

}
