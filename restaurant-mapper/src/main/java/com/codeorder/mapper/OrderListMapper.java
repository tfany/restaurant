package com.codeorder.mapper;

import com.codeorder.my.mapper.MyMapper;
import com.codeorder.pojo.OrderList;

import java.util.List;

public interface OrderListMapper extends MyMapper<OrderList> {
    int placeOrderList(OrderList orderList);
}