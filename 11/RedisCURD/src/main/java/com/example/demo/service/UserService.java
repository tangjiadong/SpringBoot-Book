package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Tang on 2020/8/17
 * 缓存就在这层工作
 * @Cacheable 将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key
 * @CachePut 指定key，将更新的结果同步到redis中
 * @CacheEvict 指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存
 */
@Service
@CacheConfig(cacheNames = "users")
public class UserService {

    @Autowired
    UserMapper userMapper;

    //将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。
    @Cacheable(key="#p0")
    public User selectUser(String id){
        System.out.println("select");
        return userMapper.findById(id);
    }

    //@CachePut 指定key，将更新的结果同步到redis中
    @CachePut(key="#p0")
    public void updateById(User user){
        System.out.println("update");
        userMapper.updateById(user);
    }

    //@CacheEvict 指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存
    @CacheEvict(key = "#p0",allEntries = true)
    public void deleteById(String id){
        System.out.println("delete");
        userMapper.deleteById(id);
    }
}
