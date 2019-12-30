package com.codeorder.controller;

import com.codeorder.utils.CommonResult;
import com.codeorder.pojo.Category;
import com.codeorder.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/addCategory")
    public CommonResult<Object> addCategory(@RequestParam String categoryName){
        Category category=new Category();
        category.setId(1);
        category.setName(categoryName);
        categoryService.addCategory(category);
        return CommonResult.success("成功");
    }

    @GetMapping("/deleteCat")
    public CommonResult<Integer> deleteCategory(@RequestParam(value = "categoryId") int id){
        categoryService.deleteCategory(id);
        return CommonResult.success(id);
    }


}
