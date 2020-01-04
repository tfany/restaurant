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
        int result = dishService.addDish(dish);                       //返回添加菜品结果
        if(result==0)                                                 //菜品已存在
            return CommonResult.failed("该菜品已存在！");
        if(result==-1)
            return CommonResult.failed("添加菜品失败！");              //添加的菜品没有名字或价格或分类
        return CommonResult.success(null);
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

    @GetMapping("/queryDishById")
    public CommonResult<Object> queryDishById(Integer id){
        Dish dish=dishService.queryDishById(id);
        if(dish==null){
            return CommonResult.failed("未查到信息");
        }
        return CommonResult.success(dishService.queryDishById(id));
    }
}
