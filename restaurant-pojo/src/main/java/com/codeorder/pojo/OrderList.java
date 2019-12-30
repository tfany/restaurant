package com.codeorder.pojo;

import javax.persistence.*;

public class OrderList {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 订单ID
     */
    @Column(name = "orderId")
    private Integer orderId;

    /**
     * 菜品ID
     */
    @Column(name = "dishId")
    private Integer dishId;

    /**
     * 菜品数量
     */
    @Column(name = "quantity")
    private Integer quantity;

    /**
     * 是否上菜
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
     * 获取订单ID
     *
     * @return OrderId - 订单ID
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置订单ID
     *
     * @param orderId 订单ID
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取菜品ID
     *
     * @return DishId - 菜品ID
     */
    public Integer getDishId() {
        return dishId;
    }

    /**
     * 设置菜品ID
     *
     * @param dishId 菜品ID
     */
    public void setDishId(Integer dishId) {
        this.dishId = dishId;
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