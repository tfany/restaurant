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


    /**
     *  顾客下单
     * @param detailList  订单的菜品信息
     * @param tableNum  下单的餐桌号
     * @return
     */
    @Override
    public int placeOrder(List<OrderList> detailList, Integer tableNum) {
        Date date = new Date();
        Order order = new Order();
        CodeNumUtils codeNumUtils = new CodeNumUtils();
        String number = codeNumUtils.getCodeNumber();
        Double total = 0.0;
        orderMapper.placeOrder(order);
        int orderId = order.getId();
        System.out.println("orderId");
        System.out.println(orderId);
        for(OrderList orderList: detailList) {
            List<Dish> dishList = dishMapper.queryPriceByDishId(orderList.getDishId());
            orderList.setOrderId(orderId);
            orderList.setStatus(1);
            System.out.println(orderList.getQuantity());
            orderListMapper.placeOrderList(orderList);
            for(Dish dish: dishList) {
                total += dish.getPrice() * orderList.getQuantity();
            }
        }
        order.setNumber(number);
        order.setTableNum(tableNum);
        order.setCreateDate(date);
        order.setPrice(total);
        order.setPayStatus(1);
        order.setStatus(1);
        orderMapper.updateOrder(order);
        return 0;
    }

    /*
     * 查看订单详情
     */
    public List<OrderList> queryOrderByOrderId(Integer orderId) {
        return orderMapper.queryOrderByOrderId(orderId);
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

    @Override
    public int updateOrderStatusById(Integer id) {
        return orderMapper.updateOrderStatusById(id,0);
    }


}
