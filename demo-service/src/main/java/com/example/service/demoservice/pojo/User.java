package com.example.service.demoservice.pojo;

public class User {
    /**
     * 编号
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;

    /**
     * 获取编号
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取年龄
     *
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }


}
