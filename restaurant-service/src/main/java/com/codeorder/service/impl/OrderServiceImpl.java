package com.codeorder.service.impl;

import com.codeorder.mapper.DishMapper;
import com.codeorder.mapper.OrderListMapper;
import com.codeorder.mapper.OrderMapper;
import com.codeorder.pojo.Dish;
import com.codeorder.pojo.Order;
import com.codeorder.pojo.OrderList;
import com.codeorder.service.OrderService;
import com.codeorder.utils.CodeNumUtils;
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
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private OrderListMapper orderListMapper;

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
    public int placeOrder(List<OrderList> detailList, Integer tableNum) {
        Date date = new Date();
        Order order = new Order();
        CodeNumUtils codeNumUtils = new CodeNumUtils();
        String number = codeNumUtils.getCodeNumber();
        Double total = 0.0;
        int orderId = orderMapper.placeOrder(order);
        for(OrderList orderList: detailList) {
            List<Dish> dishList = dishMapper.queryPriceByDishId(orderList.getDishId());
            orderList.setOrderId(orderId);
            orderList.setStatus(1);
            orderListMapper.placeOrderList(orderList);
            for(Dish dish: dishList) {
                total += dish.getPrice() * orderList.getQuantity();
            }
        }
        order.setNumber(number);
        order.setTableNum(tableNum);
        order.setCreateTime(date);
        order.setPrice(total);
        order.setPayStatus(1);
        order.setStatus(1);
        orderMapper.placeOrder(order);


        return 0;
    }


}
