package com.codeorder.service.impl;

import com.codeorder.mapper.OrderListMapper;
import com.codeorder.pojo.OrderList;
import com.codeorder.pojo.OrderListDtoToUI;
import com.codeorder.service.OrderListService;
import com.codeorder.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderListServiceImpl implements OrderListService {

    @Autowired
    OrderListMapper orderListMapper;

    @Override
    public int updateOrderListStatus(OrderList orderList) {
        return orderListMapper.updateOrderListStatus(orderList);
    }

    @Override
    public Map<String, Object> getOrderListDetail(Integer pageNum, Integer pageSize,Integer orderId) {
        PageHelper.startPage(pageNum, pageSize);
        List<OrderListDtoToUI> list = orderListMapper.queryOrderDetailById(orderId);
        PageInfo<OrderListDtoToUI> pageInfo=new PageInfo<>(list);
        return PageUtil.getPageInfo(pageInfo,list);
    }

}
