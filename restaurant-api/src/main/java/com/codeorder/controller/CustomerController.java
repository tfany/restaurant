package com.codeorder.controller;

import com.codeorder.pojo.OrderList;
import com.codeorder.pojo.OrderListDto;
import com.codeorder.service.OrderService;
import com.codeorder.utils.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fanzhang
 * @date 2020/1/2 - 10:22
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    @ResponseBody
    /**
     * 顾客下单
     */
    public CommonResult<Object> placeOrder(@RequestBody OrderListDto orderListDto) {
        return CommonResult.success(orderService.placeOrder(orderListDto.getDetailList(),orderListDto.getTableNum()));
    }

}
