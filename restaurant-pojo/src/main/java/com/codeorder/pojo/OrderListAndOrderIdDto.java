package com.codeorder.pojo;

import java.util.List;

public class OrderListAndOrderIdDto {

    private List<OrderList> detailList;

    private Integer orderId;

    public OrderListAndOrderIdDto(List<OrderList> detailList, Integer orderId) {
        this.detailList = detailList;
        this.orderId = orderId;
    }

    public OrderListAndOrderIdDto() {
    }

    public List<OrderList> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<OrderList> detailList) {
        this.detailList = detailList;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
