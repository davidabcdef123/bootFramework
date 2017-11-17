package com.dave.sun.dao.test2;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

/**
 * Created by Super.Sun on 2017/11/16.
 */
public interface UserMapper2 {

    @Select({
            "select",
            "count(1) count",
            "from db",
    })
    @Results({
            @Result(column="count", property="count", jdbcType= JdbcType.INTEGER),
    })
    Integer query();
}
