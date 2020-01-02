package com.codeorder.mapper;

import com.codeorder.my.mapper.MyMapper;
import com.codeorder.pojo.Order;

import java.util.Date;
import java.util.List;

public interface OrderMapper extends MyMapper<Order> {
    List<Order> queryOrderByTime(Date startTime, Date endTime);
    List<Order> queryAllOrder();
    Order queryById(String orderId);
    Integer changeStatus(String number,Integer status);
    Integer getOrderIdByNumber(String number);
}