package com.codeorder.controller;

import com.codeorder.service.DishService;
import com.codeorder.utils.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class DishController {
    @Autowired
    private DishService dishService;
    @RequestMapping("/deleteDish")
    public CommonResult<String> deleteDish(@Param("dishId") Integer id){
        int result=dishService.deleteDish(id);
        if(result==1){
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed("操作失败");
    }
}
