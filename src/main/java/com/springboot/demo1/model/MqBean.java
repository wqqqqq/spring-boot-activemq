package com.springboot.demo1.model;

import java.io.Serializable;

public class MqBean implements Serializable {
    private Integer age;
    private String name;
    private static final long serialVersionUID = 1L;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
