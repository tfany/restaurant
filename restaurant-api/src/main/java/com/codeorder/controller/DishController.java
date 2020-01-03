package com.codeorder.controller;

import com.codeorder.pojo.Dish;
import com.codeorder.service.DishService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/manager")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/dish")
    public CommonResult<Object> showAllDish(int pageNum,int pageSize){
        return CommonResult.success(dishService.queryAllDish(pageNum,pageSize));
    }
    @PostMapping("/addDish")
    public CommonResult addDish(@RequestBody Dish dish){
        int result = dishService.addDish(dish);
        if(result!=0)
            return CommonResult.success(null);
        return CommonResult.failed("该菜品已存在");
    }

    @GetMapping("/searchDish")
    public CommonResult<Object> searchDish(Integer pageNum, Integer pageSize,String name,Integer categoryId){
        return CommonResult.success(dishService.queryDishByCategoryOrName(pageNum,pageSize,name,categoryId));
    }

    @PostMapping("/deleteDish")
    public CommonResult<Object> deleteDish(Integer id){
        return CommonResult.success(dishService.deleteDish(id));
    }

    @PostMapping("/updateDish")
    public CommonResult<Object> updateDish(@RequestBody Dish dish){
        return CommonResult.success(dishService.updateDish(dish));
    }

    @GetMapping("/updateInfo/{id}")
    public CommonResult<Object> queryDishById(@PathVariable Integer id){
        return CommonResult.success(dishService.queryDishById(id));
    }
}
