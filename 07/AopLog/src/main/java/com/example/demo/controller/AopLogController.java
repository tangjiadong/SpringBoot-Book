package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tang on 2020/8/18
 */
@RestController
public class AopLogController {
    @GetMapping("/aoptest")
    public String aVoid(){
        return "hello aop test";
    }
}
