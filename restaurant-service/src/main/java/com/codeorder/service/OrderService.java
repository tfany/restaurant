package com.codeorder.service;

import com.codeorder.pojo.Order;

import com.codeorder.pojo.OrderList;


import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderService {
    Map<String,Object> queryOrderByTime(Integer pageNum, Integer pageSize,Date startTime, Date endTime);
    Map<String,Object> queryAllOrder(Integer pageNum, Integer pageSize);

    int placeOrder(List<OrderList> detailList,Integer tableNum);

    Order queryById(Integer orderId);

    Integer changeStatus(String number,Integer newStatus);
    Integer getOrderIdByNumber(String number);
}
