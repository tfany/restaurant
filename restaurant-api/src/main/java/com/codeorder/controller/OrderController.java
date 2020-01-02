package com.codeorder.controller;

import com.codeorder.pojo.OrderList;
import com.codeorder.service.OrderService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("manager")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/queryByTime")
    public CommonResult<Object> queryByTime(Integer pageNum, Integer pageSize,Date startTime,Date endTime){
        return CommonResult.success(orderService.queryOrderByTime(pageNum,pageSize,startTime,endTime));
    }

    @RequestMapping("/placeOrder")
    public CommonResult<Object> placeOrder(List<OrderList> detailList,Integer tableNum) {
        return CommonResult.success(orderService.placeOrder(detailList,tableNum));
    }

}
