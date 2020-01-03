package com.codeorder.pojo;

public class CategoryDto {
    public CategoryDto(Integer id, String name, Integer count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    /*
     * 菜品分类id
     * */
    private Integer id;
    /*
     * 菜品分类名
     * */
    private String name;
    /*
     * 菜品分类下菜品数量
     * */
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
