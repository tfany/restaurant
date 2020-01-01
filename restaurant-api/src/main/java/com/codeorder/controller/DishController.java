package com.codeorder.controller;

import com.codeorder.pojo.Dish;
import com.codeorder.service.DishService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    public CommonResult<Object> addDish(Dish dish){
        return CommonResult.success(dishService.addDish(dish));
    }

    @GetMapping("/searchDish")
    public CommonResult<Object> searchDish(Integer pageSize, Integer pageNum,String name,Integer categoryId){
        return CommonResult.success(dishService.queryDishByCategoryOrName(pageSize,pageNum,name,categoryId));
    }

    @PostMapping("/deleteDish")
    public CommonResult<Object> deleteDish(Integer id){
        return CommonResult.success(dishService.deleteDish(id));
    }

    @PostMapping("/updateDish")
    public CommonResult<Object> updateDish(Dish dish){
        return CommonResult.success(dishService.updateDish(dish));
    }

}
