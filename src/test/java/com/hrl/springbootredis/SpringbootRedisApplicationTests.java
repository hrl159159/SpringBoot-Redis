package com.hrl.springbootredis;

import com.hrl.springbootredis.RedisTest.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootRedisApplicationTests {
@Autowired
private StringRedisTemplate stringRedisTemplate;
    @Test
    void contextLoads() {


    }

    /**
     * 操作String类型
     */
    @Test
    public void OperateString(){
        stringRedisTemplate.opsForValue().set("hrl","侯荣亮");
        String hrl=stringRedisTemplate.opsForValue().get("hrl");
        System.out.println(hrl);
    }


    /**
     * 操作List类型
     */

    @Test
    public void OperateList(){
        ListOperations<String,String> listOperations=stringRedisTemplate.opsForList();
        String key="list";
        listOperations.leftPush(key,"侯荣亮");
        listOperations.leftPush(key,"侯洁红");
        listOperations.leftPush(key,"傻逼");
        System.out.println(listOperations.range(key,0,2));
        System.out.println(listOperations.index(key,0));

    }

    /**
     * 操作Hash
     */
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Test
    public void OperateHash(){
        String key="user";
        User user1=new User("1606100103","侯荣亮",23);
        HashOperations<String,String, User> hashOperations=redisTemplate.opsForHash();
        hashOperations.put(key,"user1",user1);
        System.out.println(hashOperations.get(key,"user1"));

    }

}
