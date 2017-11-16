package com.dave.sun.service.impl;

import com.alibaba.fastjson.JSON;
import com.dave.sun.dao.UserEntityMapper;
import com.dave.sun.service.IDemoService;
import com.dave.sun.vo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Super.Sun on 2017/11/13.
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    RedisTemplate redisTemplate;

    @Resource(name="redisTemplate")
    ValueOperations<Object, Object> valOps; //4

    /*@Autowired
    UserMapper demoMapper;*/
    @Autowired
    UserEntityMapper userEntityMapper;

  /*  @Autowired
    @Qualifier("redisTemplate")
    ValueOperations<Object, Object> valOps; //4*/

    @Override
    public void redisAdd() {
        /*try {
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
        }*/

        /*valOps.set("test1","张三");
        valOps.set("test2","李四", TimeUnit.HOURS.toMinutes(1));*/
    }

    @Override
    public int userAdd() {
      /*  try {
             demoMapper.insert("张三", 99);
            //demoMapper.findByName("张三");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return 0;
    }

    @Override
    public List queryUser() {
        /*List<User> list=demoMapper.getAll();
        System.out.println(list.size());
        return list;*/
        return null;
    }

    @Override
    public int deleteByPrimaryKey() {
        return userEntityMapper.deleteByPrimaryKey("15");
    }

    @Override
    public int insert() {
        try {
            UserEntity user=new UserEntity("张三");
            user.setId("999");
            user.setCompanyId("999");
            user.setOfficeId("999");
            user.setLoginName("999");
            user.setPassword("999");
            user.setCreateBy("999");
            user.setCreateDate(new Date());
            user.setUpdateBy("999");
            user.setUpdateDate(new Date());
            user.setDelFlag("1");
            return userEntityMapper.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertSelective() {
        try {
            UserEntity user=new UserEntity("李四");
            user.setId("9991");
            user.setCompanyId("999");
            user.setOfficeId("999");
            user.setLoginName("999");
            user.setPassword("999");
            user.setCreateBy("999");
            user.setCreateDate(new Date());
            user.setUpdateBy("999");
            user.setUpdateDate(new Date());
            user.setDelFlag("1");
            return userEntityMapper.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public UserEntity selectByPrimaryKey() {
        return userEntityMapper.selectByPrimaryKey("1");
    }

    @Override
    public int updateByPrimaryKeySelective() {
        try {
            UserEntity user = new UserEntity();
            user.setId("999");
            user.setName("zhang");
            return userEntityMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateByPrimaryKey() {
        try {
            UserEntity user = new UserEntity();
            user.setId("2");
            user.setName("赵六");
            return userEntityMapper.updateByPrimaryKey(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<UserEntity> selectByExample() {
        UserEntity user = new UserEntity();
        user.setName("系统管理员");
        user.setId("1");
        List<UserEntity> list=userEntityMapper.selectByExample(user);
        return list;
    }

}
