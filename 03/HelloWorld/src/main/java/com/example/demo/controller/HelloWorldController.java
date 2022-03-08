package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 */
@RestController
public class HelloWorldController {
    @RequestMapping(value="/hello")
    public String hello(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        return "Hello,Spring Boot!";
    }

}
