package com.example.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
//		SpringApplication sApp = new SpringApplication(HelloWorldApplication.class);
//		sApp.setBannerMode(Banner.Mode.OFF);
//		sApp.run(args);
		SpringApplication.run(HelloWorldApplication.class,args);
	}

}
