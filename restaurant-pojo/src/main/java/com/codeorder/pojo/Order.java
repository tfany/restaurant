package com.codeorder.pojo;

import javax.persistence.*;
import java.util.Date;

public class Order {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 订单号
     */
    @Column(name = "number")
    private String number;

    /**
     * 桌号
     */
    @Column(name = "tableNum")
    private Integer tableNum;

    /**
     * 订单生成日期
     */
    @Column(name = "createDate")
    private Date createDate;

    /**
     * 总价格
     */
    @Column(name = "price")
    private Double price;

    /**
     * 状态（已付款或未付款）0付款，1未付款
     */
    @Column(name = "payStatus")
    private Integer payStatus;

    /**
     * 是否完单：0表示完单；1表示未完单
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 获取主键ID
     *
     * @return Id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取订单号
     *
     * @return Number - 订单号
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置订单号
     *
     * @param number 订单号
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 获取桌号
     *
     * @return TableNum - 桌号
     */
    public Integer getTableNum() {
        return tableNum;
    }

    /**
     * 设置桌号
     *
     * @param tableNum 桌号
     */
    public void setTableNum(Integer tableNum) {
        this.tableNum = tableNum;
    }

    /**
     * 获取订单生成日期
     *
     * @return Date - 订单生成日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置订单生成日期
     *
     * @param createDate 订单生成日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取总价格
     *
     * @return Price - 总价格
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置总价格
     *
     * @param price 总价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取状态（已付款或未付款）0付款，1未付款
     *
     * @return PayStatus - 状态（已付款或未付款）0付款，1未付款
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * 设置状态（已付款或未付款）0付款，1未付款
     *
     * @param payStatus 状态（已付款或未付款）0付款，1未付款
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 获取是否完单：0表示完单；1表示未完单
     *
     * @return Status - 是否完单：0表示完单；1表示未完单
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置是否完单：0表示完单；1表示未完单
     *
     * @param status 是否完单：0表示完单；1表示未完单
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

}