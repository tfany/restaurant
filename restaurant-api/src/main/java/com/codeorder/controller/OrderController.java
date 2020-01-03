package com.codeorder.controller;

import com.codeorder.pojo.Order;
import com.codeorder.service.OrderService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
@RequestMapping("manager")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @GetMapping("/queryByTime")
    public CommonResult<Object> queryByTime(Integer pageNum, Integer pageSize,Date startTime,Date endTime){
        return CommonResult.success(orderService.queryOrderByTime(pageNum,pageSize,startTime,endTime));
    }

    @GetMapping("/queryById")
    public CommonResult<Object> queryById(String orderId){
        Order order=orderService.queryById(orderId);
        if(order==null){
            return CommonResult.failed("未查到订单！");
        }
        return CommonResult.success(order);
    }

    @GetMapping("/queryAllOeder")
    public CommonResult<Object> queryAllOeder(){
        return CommonResult.success(orderService.queryAllOrder(1,1));
    }
    @GetMapping("/settleAcount")
    public CommonResult<Object> settleAcount(String number)
    {
        int res=orderService.changeStatus(number,1);
        return CommonResult.success(res);
    }
    @GetMapping("/getOrderIdByNumber")
    public CommonResult<Object> getOrderIdByNumber(String number)
    {
        int res=orderService.getOrderIdByNumber(number);
        return CommonResult.success(res);
    }
}
