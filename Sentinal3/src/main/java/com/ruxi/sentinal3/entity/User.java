package com.ruxi.sentinal3.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String id;

    private String userName;

    private Integer age;


    public User(String id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }
}
