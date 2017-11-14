package com.dave.sun.service.impl;

import com.alibaba.fastjson.JSON;
import com.dave.sun.IDemoMapper;
import com.dave.sun.service.IDemoService;
import com.dave.sun.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Super.Sun on 2017/11/13.
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    RedisTemplate redisTemplate;

    @Resource(name="redisTemplate")
    ValueOperations<Object, Object> valOps; //4

    @Autowired
    IDemoMapper demoMapper;

  /*  @Autowired
    @Qualifier("redisTemplate")
    ValueOperations<Object, Object> valOps; //4*/

    @Override
    public void redisAdd() {
        try {
            User user1 = new User("张三", 11, "2222@qq.com");
            ValueOperations<String, User> operations=redisTemplate.opsForValue();
            operations.set("user1",user1);
            valOps.set("user3", JSON.toJSONString(user1));
            valOps.set("user2",user1);
            User userR=operations.get("user1");
            System.out.println(userR.getName());
            System.out.println(valOps.get("user3"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*valOps.set("test1","张三");
        valOps.set("test2","李四", TimeUnit.HOURS.toMinutes(1));*/
    }

    @Override
    public int userAdd() {
        return demoMapper.insert("张三", 11);
    }
}
