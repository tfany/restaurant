package com.codeorder.service.impl;

import com.codeorder.mapper.OrderMapper;
import com.codeorder.pojo.Order;
import com.codeorder.service.OrderService;
import com.codeorder.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /*
    * 按照时间段查询
    * */
    @Override
    public Map<String, Object> queryOrderByTime(Integer pageNum, Integer pageSize,Date startTime, Date endTime) {
        if (startTime == null && endTime == null) {
            return queryAllOrder(pageNum,pageSize);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Order> list=orderMapper.queryOrderByTime(startTime,endTime);
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        return PageUtil.getPageInfo(pageInfo,list);
    }
    /*
    * 查询全部订单
    * */
    @Override
    public Map<String, Object> queryAllOrder(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> list=orderMapper.queryAllOrder();
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        return PageUtil.getPageInfo(pageInfo,list);
    }

    @Override
    public Order queryById(Integer orderId) {
        return orderMapper.queryById(orderId);
    }

    /*
    * 改变订单状态
    * */
    @Override
    public Integer changeStatus(String number,Integer newStatus) {
        return orderMapper.changeStatus(number,newStatus);
    }
    @Override
    public Integer getOrderIdByNumber(String number) {
        return orderMapper.getOrderIdByNumber(number);
    }
}
