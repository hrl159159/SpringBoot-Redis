package com.hrl.springbootredis.RedisTest.Entity;

import java.io.Serializable;

public class User implements Serializable {//实现序列化接口
    private String Id;
    private String Name;
    private Integer Age;



    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public User(String Id,String Name,Integer Age){
        this.Id=Id;
        this.Name=Name;
        this.Age=Age;
    }
}
