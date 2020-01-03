package com.codeorder.mapper;

import com.codeorder.my.mapper.MyMapper;
import com.codeorder.pojo.Order;
import org.apache.ibatis.annotations.Param;
import com.codeorder.pojo.OrderList;

import java.util.Date;
import java.util.List;

public interface OrderMapper extends MyMapper<Order> {
    List<Order> queryOrderByTime(Date startTime, Date endTime);
    List<Order> queryAllOrder();


    /**
     * 添加一条订单信息
     * @param order
     * @return
     */
    int placeOrder(Order order);

    /**
     * 更新一条订单信息
     * @param order
     * @return
     */
    int updateOrder(Order order);
    Order queryById(Integer orderId);
    Integer changeStatus(String number,Integer status);
    Integer getOrderIdByNumber(String number);

    /**
     * 修改订单完单状态
     * @return
     */
    int updateOrderStatusById(@Param("id") Integer id , @Param("status") Integer status);

    List<OrderList> queryOrderByOrderId(Integer orderId);
}