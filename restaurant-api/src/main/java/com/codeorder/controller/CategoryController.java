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
        return CommonResult.success(category);
    }

    @GetMapping("/deleteCat")
    public CommonResult deleteCategory(@RequestParam(value = "categoryId") int id){
        int res=categoryService.deleteCategory(id);
        if(res==1){
            return CommonResult.success(res);
        }
        else{
            return CommonResult.failed("操作失败,请检查输入的ID");
        }
    }


}
