package com.codeorder.pojo;

import javax.persistence.*;

public class Orderlist {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 订单ID
     */
    @Column(name = "OrderId")
    private Integer orderid;

    /**
     * 菜品ID
     */
    @Column(name = "DishId")
    private Integer dishid;

    /**
     * 菜品数量
     */
    @Column(name = "Quantity")
    private Integer quantity;

    /**
     * 是否上菜
     */
    @Column(name = "Status")
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
     * 获取订单ID
     *
     * @return OrderId - 订单ID
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * 设置订单ID
     *
     * @param orderid 订单ID
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    /**
     * 获取菜品ID
     *
     * @return DishId - 菜品ID
     */
    public Integer getDishid() {
        return dishid;
    }

    /**
     * 设置菜品ID
     *
     * @param dishid 菜品ID
     */
    public void setDishid(Integer dishid) {
        this.dishid = dishid;
    }

    /**
     * 获取菜品数量
     *
     * @return Quantity - 菜品数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置菜品数量
     *
     * @param quantity 菜品数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取是否上菜
     *
     * @return Status - 是否上菜
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置是否上菜
     *
     * @param status 是否上菜
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}