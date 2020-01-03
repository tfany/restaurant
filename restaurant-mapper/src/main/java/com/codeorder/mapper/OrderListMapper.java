package com.codeorder.mapper;

import com.codeorder.my.mapper.MyMapper;
import com.codeorder.pojo.OrderList;

import java.util.List;

public interface OrderListMapper extends MyMapper<OrderList> {
    /**
     * 添加订单菜品的详细信息
     * @param orderList
     * @return
     */
    int placeOrderList(OrderList orderList);
}