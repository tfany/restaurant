package com.codeorder.service;

import com.codeorder.pojo.OrderList;

public interface OrderListService {

    /**
     * 修改订单项状态
     * @param orderList
     * @return
     */
    int updateOrderListStatus(OrderList orderList);

}
