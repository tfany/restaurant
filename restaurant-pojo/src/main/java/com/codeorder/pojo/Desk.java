package com.codeorder.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 桌子
 */
public class Desk {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 桌号
     */
    @Column(name = "deskNum")
    private Integer deskNum;

    /**
     * 图片url
     */
    @Column(name = "url")
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeskNum() {
        return deskNum;
    }

    public void setDeskNum(Integer deskNum) {
        this.deskNum = deskNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "id=" + id +
                ", deskNum=" + deskNum +
                ", url='" + url + '\'' +
                '}';
    }
}
