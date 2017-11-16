package com.dave.sun.service;


import com.dave.sun.vo.UserEntity;

import java.util.List;

/**
 * Created by Super.Sun on 2017/11/13.
 */
public interface IDemoService {

    public void redisAdd();

    public int deleteByPrimaryKey();

    public int insert();

    public int insertSelective();

    public UserEntity selectByPrimaryKey();

    public int updateByPrimaryKeySelective();

    public int updateByPrimaryKey();

    public List<UserEntity> selectByExample();
}
