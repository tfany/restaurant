package com.codeorder.service;

import com.codeorder.pojo.Order;

import com.codeorder.pojo.OrderList;


import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderService {
    Map<String,Object> queryOrderByTime(Integer pageNum, Integer pageSize,String startTime, String endTime);
    Map<String,Object> queryAllOrder(Integer pageNum, Integer pageSize);
    int placeOrder(List<OrderList> detailList,Integer tableNum);
    Order queryById(Integer orderId);
    Map<String, Object> queryTodayOrder(Integer pageNum, Integer pageSize,Integer status,String createDate);
    Integer changeStatus(String number,Integer newStatus);
    Integer getOrderIdByNumber(String number);

    /**
     * 修改订单完单状态
     * @param id
     * @return
     */
    int updateOrderStatusById(Integer id);
    int updateOrderPriceById(Integer id,Integer price);
    List<OrderList> queryOrderByOrderId(Integer orderId);

    List<Order> queryByTable(Integer tableNum,Integer payStatus);
}
