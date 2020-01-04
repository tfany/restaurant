package com.codeorder.service;

import com.codeorder.pojo.OrderList;

import java.util.Map;

public interface OrderListService {

    /**
     * 修改订单项状态
     * @param orderList
     * @return
     */
    int updateOrderListStatus(OrderList orderList);

    /**
     * 返回封装的订单明细
     */
    Map<String,Object> getOrderListDetail(Integer orderId,Integer pageSize,Integer pageNum);

}
