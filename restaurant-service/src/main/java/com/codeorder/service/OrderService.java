package com.codeorder.service;

import java.util.Date;
import java.util.Map;

public interface OrderService {
    Map<String,Object> queryOrderByTime(Integer pageNum, Integer pageSize,Date startTime, Date endTime);
    Map<String,Object> queryAllOrder(Integer pageNum, Integer pageSize);
}
