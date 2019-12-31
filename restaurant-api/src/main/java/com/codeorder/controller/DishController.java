package com.codeorder.controller;

import com.codeorder.pojo.Dish;
import com.codeorder.service.DishService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/manager")
public class DishController {

    @Autowired
    private DishService dishService;

    @RequestMapping("/dish")
    public CommonResult<Object> showAllDish(){
        return CommonResult.success(dishService.queryAllDish());
    }

    @RequestMapping("/addDish")
    public CommonResult<Object> addDish(Dish dish){
        return CommonResult.success(dishService.addDish(dish));
    }

    @RequestMapping("/searchDish")
    public CommonResult<Object> searchDish(Integer pageSize, Integer pageNum,String name,Integer categoryId){
        return CommonResult.success(dishService.queryDishByCategoryOrName(pageSize,pageNum,name,categoryId));
    }

    @RequestMapping("/deleteDish")
    public CommonResult<Object> deleteDish(Integer id){
        return CommonResult.success(dishService.deleteDish(id));
    }

    @RequestMapping("/updateDish")
    public CommonResult<Object> updateDish(Dish dish){
        return CommonResult.success(dishService.updateDish(dish));
    }

}
