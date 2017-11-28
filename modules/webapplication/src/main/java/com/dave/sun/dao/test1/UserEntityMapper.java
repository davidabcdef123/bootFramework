package com.dave.sun.dao.test1;

import com.dave.sun.vo.User;
import com.dave.sun.vo.UserEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserEntityMapper {
    @Delete({
        "delete from sys_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into sys_user (id, company_id, ",
        "office_id, login_name, ",
        "password, no, name, ",
        "email, phone, mobile, ",
        "user_type, photo, login_ip, ",
        "login_date, login_flag, ",
        "create_by, create_date, ",
        "update_by, update_date, ",
        "remarks, del_flag)",
        "values (#{id,jdbcType=VARCHAR}, #{companyId,jdbcType=VARCHAR}, ",
        "#{officeId,jdbcType=VARCHAR}, #{loginName,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{no,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
        "#{userType,jdbcType=CHAR}, #{photo,jdbcType=VARCHAR}, #{loginIp,jdbcType=VARCHAR}, ",
        "#{loginDate,jdbcType=TIMESTAMP}, #{loginFlag,jdbcType=VARCHAR}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{remarks,jdbcType=VARCHAR}, #{delFlag,jdbcType=CHAR})"
    })
    int insert(UserEntity record);

    @InsertProvider(type=UserEntitySqlProvider.class, method="insertSelective")
    int insertSelective(UserEntity record);

    @Select({
        "select",
        "id, company_id, office_id, login_name, password, no, name, email, phone, mobile, ",
        "user_type, photo, login_ip, login_date, login_flag, create_by, create_date, ",
        "update_by, update_date, remarks, del_flag",
        "from sys_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="company_id", property="companyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="office_id", property="officeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="no", property="no", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_type", property="userType", jdbcType=JdbcType.CHAR),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_ip", property="loginIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_date", property="loginDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="login_flag", property="loginFlag", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.CHAR)
    })
    UserEntity selectByPrimaryKey(String id);

    @UpdateProvider(type=UserEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserEntity record);

    @Update({
        "update sys_user",
        "set company_id = #{companyId,jdbcType=VARCHAR},",
          "office_id = #{officeId,jdbcType=VARCHAR},",
          "login_name = #{loginName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "no = #{no,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "user_type = #{userType,jdbcType=CHAR},",
          "photo = #{photo,jdbcType=VARCHAR},",
          "login_ip = #{loginIp,jdbcType=VARCHAR},",
          "login_date = #{loginDate,jdbcType=TIMESTAMP},",
          "login_flag = #{loginFlag,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "remarks = #{remarks,jdbcType=VARCHAR},",
          "del_flag = #{delFlag,jdbcType=CHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(UserEntity record);

    @SelectProvider(type=UserEntitySqlProvider.class, method="selectByExample")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="company_id", property="companyId", jdbcType=JdbcType.VARCHAR),
            @Result(column="office_id", property="officeId", jdbcType=JdbcType.VARCHAR),
            @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="no", property="no", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_type", property="userType", jdbcType=JdbcType.CHAR),
            @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR),
            @Result(column="login_ip", property="loginIp", jdbcType=JdbcType.VARCHAR),
            @Result(column="login_date", property="loginDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="login_flag", property="loginFlag", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR),
            @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.CHAR)
    })
    List<UserEntity> selectByExample(UserEntity example);

    @Select({
            "select",
            "id, name from user"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
    })
    List<User> selectUserPage();
}