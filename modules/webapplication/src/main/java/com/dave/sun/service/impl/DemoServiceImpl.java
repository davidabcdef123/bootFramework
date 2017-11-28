package com.dave.sun.service.impl;

import com.alibaba.fastjson.JSON;
import com.dave.sun.dao.test1.UserEntityMapper;
import com.dave.sun.dao.test2.UserMapper2;
import com.dave.sun.service.IDemoService;
import com.dave.sun.vo.UserEntity;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Super.Sun on 2017/11/13.
 */
@Service
public class DemoServiceImpl implements IDemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    RedisTemplate redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOps; //4

    /*@Autowired
    UserMapper demoMapper;*/
    @Autowired
    UserEntityMapper userEntityMapper;

    @Autowired
    UserMapper2 userMapper2;

  /*  @Autowired
    @Qualifier("redisTemplate")
    ValueOperations<Object, Object> valOps; //4*/

    @Override
    public List<UserEntity> getUserList(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<UserEntity> list = userEntityMapper.selectByExample(new UserEntity());
        return list;
    }

    @Override
    public void redisAdd() {
        try {
            UserEntity user1 = new UserEntity();
            user1.setName("张三");
            user1.setId("123");
            user1.setEmail("2222@qq.com");
            ValueOperations<String, UserEntity> operations = redisTemplate.opsForValue();
            operations.set("user1", user1);
            valOps.set("user3", JSON.toJSONString(user1));
            valOps.set("user2", user1);
            UserEntity userR = operations.get("user1");
            System.out.println(userR.getName());
            System.out.println(valOps.get("user3"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        valOps.set("test1", "张三");
        valOps.set("test2", "李四", TimeUnit.HOURS.toMinutes(1));
    }


    @Override
    public int deleteByPrimaryKey() {
        return userEntityMapper.deleteByPrimaryKey("15");
    }

    @Override
    public int insert() {
        try {
            UserEntity user = new UserEntity("张三");
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
            UserEntity user = new UserEntity("李四");
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
        List<UserEntity> list = userEntityMapper.selectByExample(user);
        return list;
    }

    @Override
    public void datesource1() {
        List<UserEntity> userEntities = null;
        try {
            userEntities = userEntityMapper.selectByExample(new UserEntity("张三"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(userEntities.get(0).getName());
    }

    @Override
    public void datesource2() {
        try {
            System.out.println(userMapper2.query());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
