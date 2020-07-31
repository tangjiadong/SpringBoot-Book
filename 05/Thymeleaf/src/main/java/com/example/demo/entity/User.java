package com.example.demo.entity;

import lombok.Data;

/**
 * Created by Tang on 2020/7/31
 */
@Data
public class User {
    private long id;
    private String name;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
