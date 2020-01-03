package com.codeorder.mapper;

import com.codeorder.my.mapper.MyMapper;
import com.codeorder.pojo.OrderList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import java.util.List;

public interface OrderListMapper extends MyMapper<OrderList> {

    /**
     * 更新订单项状态
     * @param orderList
     * @return
     */
    int updateOrderListStatus(OrderList orderList);

    /**
     * 查询所有的订单项状态
     * @return
     */
    List<Integer> queryAllOrderListStatus();

    /**
     * 查询某个订单的订单项状态
     * @param orderId
     * @return
     */
    List<Integer> queryOrderListByOrderId(@Param("orderId") Integer orderId);
    /**
     * 添加订单菜品的详细信息
     * @param orderList
     * @return
     */
    int placeOrderList(OrderList orderList);
}