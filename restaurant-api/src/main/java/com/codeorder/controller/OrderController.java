package com.codeorder.controller;

import com.codeorder.pojo.Order;
import com.codeorder.service.OrderService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("manager")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/queryByTime")
    public CommonResult<Object> queryByTime(Integer pageNum, Integer pageSize,String startTime,String endTime){
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date start;
        Date end;
        try{
            start=format.parse(startTime);
            end=format.parse(endTime);
        }catch (ParseException e){
            return CommonResult.failed("输入时间有误，请重新输入！");
        }
        return CommonResult.success(orderService.queryOrderByTime(pageNum,pageSize,start,end));
    }

    @GetMapping("/queryById")
    public CommonResult<Object> queryById(Integer orderId){
        Order order=orderService.queryById(orderId);
        if(order==null){
            return CommonResult.failed("未查到订单！");
        }
        return CommonResult.success(order);
    }

    @GetMapping("/queryAllOrder")
    public CommonResult<Object> queryAllOrder(Integer pageNum,Integer pageSize){
        return CommonResult.success(orderService.queryAllOrder(pageNum,pageSize));
    }


    @PostMapping("/settleAccount")
    public CommonResult<Object> settleAccount(String number)
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

    @GetMapping("/orderDetail")
    public CommonResult<Object> orderDetail(Integer orderId){
        if(orderService.queryOrderByOrderId(orderId)==null)
            return CommonResult.failed("不存在该订单");
        return CommonResult.success(orderService.queryOrderByOrderId(orderId));
    }

}
