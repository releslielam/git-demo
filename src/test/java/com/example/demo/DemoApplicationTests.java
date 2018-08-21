package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Test
	public void contextLoads() {

		String s = redisTemplate.execute((RedisCallback<String>) connection -> {
			Jedis jedis = (Jedis) connection.getNativeConnection();
			return jedis.set("sda", "1", "nx", "ex", 60);
		});
		if (null==s){
			Long sda = redisTemplate.execute((RedisCallback<Long>) connection -> {
				Jedis jedis = (Jedis) connection.getNativeConnection();
				return jedis.incr("sda");
			});
			System.out.println(sda);
		}
		System.out.println(s);
	}

}
