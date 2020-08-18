package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by Tang on 2020/8/18
 */
@RestController
public class HelloWorldController {
    //WebFlux默认使用的是Netty服务器
    @GetMapping("/helloworld")
    public Mono<String> helloworld(){
        return Mono.just("This is WebFlux demo");
    }
}
