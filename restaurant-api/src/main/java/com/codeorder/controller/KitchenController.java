package com.codeorder.controller;

import com.codeorder.pojo.OrderList;
import com.codeorder.pojo.OrderListAndOrderIdDto;
import com.codeorder.service.DishService;
import com.codeorder.service.OrderListService;
import com.codeorder.service.OrderService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    @Autowired
    private OrderListService orderListService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private DishService dishService;

    @PostMapping("/updateOrder")
    public CommonResult<Object> updateOrder(@RequestBody OrderListAndOrderIdDto orderListAndOrderIdDto){
        Integer id = orderListAndOrderIdDto.getOrderId();
        int total=0;
        for(OrderList orderList:orderListAndOrderIdDto.getDetailList()){
            orderListService.updateOrderListStatus(orderList);
            total+=dishService.queryDishById(orderList.getDishId()).getPrice()*orderList.getQuantity();
        }
        orderService.updateOrderStatusById(id);
        orderService.updateOrderPriceById(id,total);
        return CommonResult.success("已完单");
    }

}
