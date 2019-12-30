package com.codeorder.controller;

import com.codeorder.utils.CommonResult;
import com.codeorder.pojo.Category;
import com.codeorder.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RestController
@RequestMapping("manager")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/addCategory")
    public CommonResult addCategory(@RequestParam String categoryName){
        int result = categoryService.addCategory(categoryName);
        if(result!=0) return CommonResult.success("添加成功");
        return CommonResult.failed("该分类已存在");
    }

    @GetMapping("/deleteCat")
    public CommonResult<Integer> deleteCategory(@RequestParam(value = "categoryId") int id){
        categoryService.deleteCategory(id);
        return CommonResult.success(id);
    }

    @RequestMapping("/updateCategory")
    public CommonResult<String> updateCategory(Category category) {
        Integer result = categoryService.updateCategory(category);
        if (result == 1) {
            return CommonResult.success("修改成功");
        } else
            return CommonResult.failed("修改失败");
    }
}
