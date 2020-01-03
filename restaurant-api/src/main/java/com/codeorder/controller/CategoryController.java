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
import java.util.Map;

@RestController
@RequestMapping("manager")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DishService dishService;



    @PostMapping("/addCategory")
    public CommonResult addCategory(@RequestParam String categoryName) {
        int result = categoryService.addCategory(categoryName);
        if (result != 0) return CommonResult.success("添加成功");
        return CommonResult.failed("该分类已存在");
    }
    @PostMapping("/deleteCat")
    public CommonResult deleteCategory(@RequestParam(value = "categoryId") int id) {
        //先删除菜品，再删除菜品分类。
        int res1 = dishService.deleteByCategoryId(id);

        String res2=String.valueOf(categoryService.deleteCategory(id));
        return CommonResult.success(res1,res2);
    }
    @PostMapping("/updateCategory")
    public CommonResult<String> updateCategory(@RequestBody Category category) {
        Integer result = categoryService.updateCategory(category);
        if (result == 1) {
            return CommonResult.success("修改成功");
        } else
            return CommonResult.failed("修改失败");
    }
    //显示所有子分类
    @GetMapping("category")
    public CommonResult<Map<String, Object>> list(Integer pageNum, Integer pageSize) {
        Map<String, Object> map = categoryService.categoryList(pageNum, pageSize);
        return CommonResult.success(map);
    }

    //根据id获取分类
    @GetMapping("getCategoryId")
    public CommonResult<Object> getCategory(Integer id) {
        return CommonResult.success(categoryService.getCategoryById(id));
    }


}
