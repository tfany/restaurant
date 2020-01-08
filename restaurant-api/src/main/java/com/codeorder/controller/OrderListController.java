package com.codeorder.controller;

import com.codeorder.pojo.Order;
import com.codeorder.pojo.OrderList;
import com.codeorder.service.OrderListService;
import com.codeorder.service.OrderService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("manager")
public class OrderListController {

    @Autowired
    private OrderListService orderListService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrderListDetail")
    public CommonResult<Object> getOrderListDetail(Integer orderId){
        return CommonResult.success(orderListService.getOrderListDetail(orderId));
    }

    @GetMapping("/getOrderDetailByIdAndStatus")
    public CommonResult<Object> getOrderDetailByIdAndStatus(String number){
        Integer orderId = orderService.getOrderIdByNumber(number);
        if(orderId==null){
            return CommonResult.failed("未查到相关订单！");
        }
        return CommonResult.success(orderListService.queryOrderDetailByIdAndStatus(orderId,1));
    }

}
