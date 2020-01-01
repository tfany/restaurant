package com.codeorder.pojo;

import javax.persistence.*;

public class Admin {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "name")
    private String name;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 用户权限:1 代表管理员；2 代表 后厨；3 收银台
     */
    @Column(name = "attribute")
    private Integer attribute;

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
     * 获取用户名
     *
     * @return Name - 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名
     *
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取密码
     *
     * @return Password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户权限:1 代表管理员；2 代表 后厨；3 收银台
     *
     * @return Limit - 用户权限:1 代表管理员；2 代表 后厨；3 收银台
     */

    public Integer getAttribute() {
        return attribute;
    }

    /**
     * 设置用户权限:1 代表管理员；2 代表 后厨；3 收银台
     *
     * @param attribute 用户权限:1 代表管理员；2 代表 后厨；3 收银台
     */
    public void setAttribute(Integer attribute) {
        this.attribute = attribute;
    }
}