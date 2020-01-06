package com.codeorder.service.impl;

import com.codeorder.mapper.OrderListMapper;
import com.codeorder.pojo.OrderList;
import com.codeorder.pojo.OrderListDtoToUI;
import com.codeorder.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderListServiceImpl implements OrderListService {

    @Autowired
    OrderListMapper orderListMapper;

    @Override
    public int updateOrderListStatus(OrderList orderList) {
        return orderListMapper.updateOrderListStatus(orderList);
    }

    public List<OrderListDtoToUI> getOrderListDetail(Integer orderId) {
        return orderListMapper.queryOrderDetailById(orderId);
    }

}
