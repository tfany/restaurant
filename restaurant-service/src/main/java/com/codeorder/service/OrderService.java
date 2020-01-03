package com.codeorder.service;

import com.codeorder.pojo.Order;

import java.util.Date;
import java.util.Map;

public interface OrderService {
    Map<String,Object> queryOrderByTime(Integer pageNum, Integer pageSize,Date startTime, Date endTime);
    Map<String,Object> queryAllOrder(Integer pageNum, Integer pageSize);
    Order queryById(String orderId);
    Integer changeStatus(String number,Integer newStatus);
    Integer getOrderIdByNumber(String number);
}
