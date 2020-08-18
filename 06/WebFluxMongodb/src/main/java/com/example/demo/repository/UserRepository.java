package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

//ReactiveMongoRepository用于操作Mongo数据库
public interface UserRepository extends ReactiveMongoRepository<User,String> {

}
