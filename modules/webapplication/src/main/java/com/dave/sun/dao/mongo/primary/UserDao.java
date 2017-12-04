package com.dave.sun.dao.mongo.primary;

import com.dave.sun.vo.UserEntity;

/**
 * Created by Super.Sun on 2017/12/4.
 */
public interface UserDao {

    public void saveUser(UserEntity user);

    public UserEntity findUserByUserName(String userName);

    public int updateUser(UserEntity user);

    public void deleteUserById(String id);
}
