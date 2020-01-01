package com.codeorder.pojo;

import javax.persistence.*;

public class Shop {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 店铺名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 店铺图片
     */
    @Column(name = "image")
    private String image;

    /**
     * 服务器地址
     */
    @Column(name = "url")
    private String url;

    /**
     * 店铺公告
     */
    @Column(name = "notice")
    private String notice;

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
     * 获取店铺名称
     *
     * @return Name - 店铺名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置店铺名称
     *
     * @param name 店铺名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取店铺图片
     *
     * @return Image - 店铺图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置店铺图片
     *
     * @param image 店铺图片
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取服务器地址
     *
     * @return Url - 服务器地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置服务器地址
     *
     * @param url 服务器地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取店铺公告
     *
     * @return Notice - 店铺公告
     */
    public String getNotice() {
        return notice;
    }

    /**
     * 设置店铺公告
     *
     * @param notice 店铺公告
     */
    public void setNotice(String notice) {
        this.notice = notice;
    }
}