package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Created by Tang on 2020/8/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    //    为name创建索引,如果需要值唯一，则设置@Indexed(unique = true)。
    private String name;
    private int age;

}
