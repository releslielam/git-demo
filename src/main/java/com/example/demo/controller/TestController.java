package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * @author Leslie.Lam
 * @create 2018-08-20 13:30
 **/
@RestController
@RequestMapping
public class TestController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("test")
    public String test(){
        String s = redisTemplate.execute((RedisCallback<String>) connection -> {
            Jedis jedis = (Jedis) connection.getNativeConnection();
            return jedis.set("lala", "1", "nx", "ex", 60);
        });
        if (null==s){
            Long sda = redisTemplate.execute((RedisCallback<Long>) connection -> {
                Jedis jedis = (Jedis) connection.getNativeConnection();
                return jedis.incr("lala");
            });
            System.out.println(Thread.currentThread().getName()+"=========="+sda);
        }
        return "success";
    }

}
