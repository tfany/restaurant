package com.codeorder.controller;

import com.codeorder.service.DishService;
import com.codeorder.service.impl.DishServiceImpl;
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

    @PostMapping("/addCategory")
    public CommonResult addCategory(@RequestParam String categoryName) {
        int result = categoryService.addCategory(categoryName);
        if (result != 0) return CommonResult.success("添加成功");
        return CommonResult.failed("该分类已存在");
    }

    @GetMapping("/deleteCat")
    public CommonResult deleteCategory(@RequestParam(value = "categoryId") int id){
        DishService dishService=new DishServiceImpl();
        //先删除菜品，再删除菜品分类。
        int res1=dishService.deleteByCategoryId(id);
        int res2=categoryService.deleteCategory(id);
        if(res1==1&&res2==1){
            return CommonResult.success(res1+res2);
        }
        return CommonResult.failed("操作失败,请检查输入的ID");
    }

    @PostMapping("/updateCategory")
    public CommonResult<String> updateCategory(Category category) {
        Integer result = categoryService.updateCategory(category);
        if (result == 1) {
            return CommonResult.success("修改成功");
        } else
            return CommonResult.failed("修改失败");
    }

    //显示所有子分类
    @GetMapping("category")
    public CommonResult<Object> list(Integer pageNum, Integer pageSize) {
        return CommonResult.success(categoryService.categoryList(pageNum, pageSize));
    }
}
