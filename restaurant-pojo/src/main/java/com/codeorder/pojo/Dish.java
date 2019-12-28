package com.codeorder.pojo;

import javax.persistence.*;

public class Dish {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 菜品名称
     */
    @Column(name = "Name")
    private String name;

    /**
     * 菜品价格
     */
    @Column(name = "Price")
    private Double price;

    /**
     * 菜品描述
     */
    @Column(name = "Detail")
    private String detail;

    /**
     * 菜品分类
     */
    @Column(name = "CategoryId")
    private Integer categoryid;

    /**
     * 菜品图片路径，所有图片路径存放在一起，用分号分隔
     */
    @Column(name = "Picture")
    private String picture;

    /**
     * 菜品是否下架：1表示菜品储备不够；2表示菜品下架
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
     * 获取菜品名称
     *
     * @return Name - 菜品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜品名称
     *
     * @param name 菜品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取菜品价格
     *
     * @return Price - 菜品价格
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置菜品价格
     *
     * @param price 菜品价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取菜品描述
     *
     * @return Detail - 菜品描述
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置菜品描述
     *
     * @param detail 菜品描述
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * 获取菜品分类
     *
     * @return CategoryId - 菜品分类
     */
    public Integer getCategoryid() {
        return categoryid;
    }

    /**
     * 设置菜品分类
     *
     * @param categoryid 菜品分类
     */
    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    /**
     * 获取菜品图片路径，所有图片路径存放在一起，用分号分隔
     *
     * @return Picture - 菜品图片路径，所有图片路径存放在一起，用分号分隔
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 设置菜品图片路径，所有图片路径存放在一起，用分号分隔
     *
     * @param picture 菜品图片路径，所有图片路径存放在一起，用分号分隔
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 获取菜品是否下架：1表示菜品储备不够；2表示菜品下架
     *
     * @return Status - 菜品是否下架：1表示菜品储备不够；2表示菜品下架
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置菜品是否下架：1表示菜品储备不够；2表示菜品下架
     *
     * @param status 菜品是否下架：1表示菜品储备不够；2表示菜品下架
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}