package com.zht.eshop.inventory.controller;

import com.zht.eshop.inventory.model.User;
import com.zht.eshop.redis.config.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
    private String testString = "testString";
    private String userKey = "userKey";

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/add")
    public String add() {
        redisUtil.set("test1","test001", 1000L);
        System.out.println(redisUtil.get("test1"));

        return "成功";
    }

    /*@GetMapping("/getUser")
    public User findUserByKey() {
        User user = (User) redisTemplate.opsForValue().get(userKey);
        return user;
    }

    @GetMapping("/getString")
    public String findString() {
        String s = stringRedisTemplate.opsForValue().get(testString);
        return s;
    }

    @GetMapping("/delete")
    public String deleteByKey() {
        //1,删除string类型
        stringRedisTemplate.delete(testString);
        //2,删除user对象
        redisTemplate.delete(userKey);
        return "删除成功";
    }*/
}