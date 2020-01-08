package com.codeorder.service;

import com.codeorder.pojo.OrderList;
import com.codeorder.pojo.OrderListDtoToUI;

import java.util.List;
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
    List<OrderListDtoToUI> getOrderListDetail(Integer orderId);

    List<OrderListDtoToUI> queryOrderDetailByIdAndStatus(Integer orderId,Integer status);


}
