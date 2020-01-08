package com.codeorder.pojo;

public class OrderListDtoToUI {
    /*
    * ordeList的id
    * */
    private Integer id;
    /*
    * 菜品名
    * */
    private String dishName;
    /*
    * 数量
    * */
    private Integer quantity;
    /*
    * 单价
    * */
    private Double price;
    /*
    * 是否上菜
    * */
    private Integer status;

    public OrderListDtoToUI(Integer id,String dishName,Integer quantity,Double price){
        this.id=id;
        this.dishName=dishName;
        this.price=price;
        this.quantity=quantity;
    }

    public String getDishName() {
        return dishName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
