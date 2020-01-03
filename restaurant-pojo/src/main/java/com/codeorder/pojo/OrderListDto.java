package com.codeorder.pojo;

import java.util.List;

/**
 * @author fanzhang
 * @date 2020/1/3 - 10:43
 */
public class OrderListDto {
    private List<OrderList> detailList;
    private Integer tableNum;

    public List<OrderList> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<OrderList> detailList) {
        this.detailList = detailList;
    }

    public Integer getTableNum() {
        return tableNum;
    }

    public void setTableNum(Integer tableNum) {
        this.tableNum = tableNum;
    }
}
