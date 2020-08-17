package com.example.demo.model;

import lombok.Data;

/**
 * Created by Tang on 2020/8/17
 */
@Data
public class User {
    //定义id
    private long id;
    //定义用户名
    private String name;
    //定义用户年龄
    private  int age;
}
