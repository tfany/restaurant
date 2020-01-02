package com.codeorder.controller;

import com.codeorder.pojo.Dish;
import com.codeorder.service.DishService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("manager")
public class DishController {
    @Autowired
    private DishService dishService;

    @PostMapping("/addDish")
    public CommonResult addDish(@RequestBody Dish dish){
        int result = dishService.addDish(dish);
        if(result!=0)
            return CommonResult.success(null);
        return CommonResult.failed("该菜品已存在");
    }

    //@GetMapping("/deleteDish")
   // public CommonResult<Integer> deleteCategory(@RequestParam(value = "diId") int id){
       // categoryService.deleteCategory(id);
       // return CommonResult.success(id);@RequestBody
   // }


}
