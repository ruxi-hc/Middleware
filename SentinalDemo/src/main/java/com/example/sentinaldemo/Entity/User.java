package com.example.sentinaldemo.Entity;

import lombok.Data;

@Data
public class User {

    private Integer id;

    private String userName;

    private Integer age;

    public User(String number, String userName, Integer age) {
    }
}
