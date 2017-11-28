package com.dave.sun.service;


import com.dave.sun.vo.User;
import com.dave.sun.vo.UserEntity;

import java.util.List;

/**
 * Created by Super.Sun on 2017/11/13.
 */
public interface IDemoService {

    public List<UserEntity> getUserList(int pageNo, int pageSize);

    public List<User> selectUserPage(int pageNo, int pageSize);

    public void redisAdd();

    public int deleteByPrimaryKey();

    public int insert();

    public int insertSelective();

    public UserEntity selectByPrimaryKey();

    public int updateByPrimaryKeySelective();

    public int updateByPrimaryKey();

    public List<UserEntity> selectByExample();

    public void datesource1();

    public void datesource2();
}
