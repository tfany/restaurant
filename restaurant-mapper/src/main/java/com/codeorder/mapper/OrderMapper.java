package com.codeorder.mapper;

import com.codeorder.my.mapper.MyMapper;
import com.codeorder.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderMapper extends MyMapper<Order> {
    List<Order> queryOrderByTime(Date startTime, Date endTime);
    List<Order> queryAllOrder();
    Order queryById(String orderId);
    Integer changeStatus(String number,Integer status);
    Integer getOrderIdByNumber(String number);

    /**
     * 修改订单完单状态
     * @return
     */
    int updateOrderStatusById(@Param("id") Integer id , @Param("status") Integer status);

}