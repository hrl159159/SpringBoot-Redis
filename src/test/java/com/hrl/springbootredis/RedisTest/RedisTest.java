package com.hrl.springbootredis.RedisTest;


import com.hrl.springbootredis.SpringbootRedisApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void OperateString(){
        stringRedisTemplate.opsForValue().set("hrl","侯荣亮");
        String hrl=stringRedisTemplate.opsForValue().get("hrl");
        System.out.println(hrl);

    }

}
