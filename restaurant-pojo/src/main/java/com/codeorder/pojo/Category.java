package com.codeorder.pojo;

import javax.persistence.*;

public class Category {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 分类名称
     */
    @Column(name = "Name")
    private String name;

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
     * 获取分类名称
     *
     * @return Name - 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分类名称
     *
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }
}