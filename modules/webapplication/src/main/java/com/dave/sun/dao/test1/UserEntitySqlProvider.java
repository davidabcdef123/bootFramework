package com.dave.sun.dao.test1;

import com.dave.sun.vo.UserEntity;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class UserEntitySqlProvider {

    public String insertSelective(UserEntity record) {
        BEGIN();
        INSERT_INTO("sys_user");

        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=VARCHAR}");
        }

        if (record.getCompanyId() != null) {
            VALUES("company_id", "#{companyId,jdbcType=VARCHAR}");
        }

        if (record.getOfficeId() != null) {
            VALUES("office_id", "#{officeId,jdbcType=VARCHAR}");
        }

        if (record.getLoginName() != null) {
            VALUES("login_name", "#{loginName,jdbcType=VARCHAR}");
        }

        if (record.getPassword() != null) {
            VALUES("password", "#{password,jdbcType=VARCHAR}");
        }

        if (record.getNo() != null) {
            VALUES("no", "#{no,jdbcType=VARCHAR}");
        }

        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }

        if (record.getEmail() != null) {
            VALUES("email", "#{email,jdbcType=VARCHAR}");
        }

        if (record.getPhone() != null) {
            VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }

        if (record.getMobile() != null) {
            VALUES("mobile", "#{mobile,jdbcType=VARCHAR}");
        }

        if (record.getUserType() != null) {
            VALUES("user_type", "#{userType,jdbcType=CHAR}");
        }

        if (record.getPhoto() != null) {
            VALUES("photo", "#{photo,jdbcType=VARCHAR}");
        }

        if (record.getLoginIp() != null) {
            VALUES("login_ip", "#{loginIp,jdbcType=VARCHAR}");
        }

        if (record.getLoginDate() != null) {
            VALUES("login_date", "#{loginDate,jdbcType=TIMESTAMP}");
        }

        if (record.getLoginFlag() != null) {
            VALUES("login_flag", "#{loginFlag,jdbcType=VARCHAR}");
        }

        if (record.getCreateBy() != null) {
            VALUES("create_by", "#{createBy,jdbcType=VARCHAR}");
        }

        if (record.getCreateDate() != null) {
            VALUES("create_date", "#{createDate,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateBy() != null) {
            VALUES("update_by", "#{updateBy,jdbcType=VARCHAR}");
        }

        if (record.getUpdateDate() != null) {
            VALUES("update_date", "#{updateDate,jdbcType=TIMESTAMP}");
        }

        if (record.getRemarks() != null) {
            VALUES("remarks", "#{remarks,jdbcType=VARCHAR}");
        }

        if (record.getDelFlag() != null) {
            VALUES("del_flag", "#{delFlag,jdbcType=CHAR}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(UserEntity record) {
        BEGIN();
        UPDATE("sys_user");

        if (record.getCompanyId() != null) {
            SET("company_id = #{companyId,jdbcType=VARCHAR}");
        }

        if (record.getOfficeId() != null) {
            SET("office_id = #{officeId,jdbcType=VARCHAR}");
        }

        if (record.getLoginName() != null) {
            SET("login_name = #{loginName,jdbcType=VARCHAR}");
        }

        if (record.getPassword() != null) {
            SET("password = #{password,jdbcType=VARCHAR}");
        }

        if (record.getNo() != null) {
            SET("no = #{no,jdbcType=VARCHAR}");
        }

        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }

        if (record.getEmail() != null) {
            SET("email = #{email,jdbcType=VARCHAR}");
        }

        if (record.getPhone() != null) {
            SET("phone = #{phone,jdbcType=VARCHAR}");
        }

        if (record.getMobile() != null) {
            SET("mobile = #{mobile,jdbcType=VARCHAR}");
        }

        if (record.getUserType() != null) {
            SET("user_type = #{userType,jdbcType=CHAR}");
        }

        if (record.getPhoto() != null) {
            SET("photo = #{photo,jdbcType=VARCHAR}");
        }

        if (record.getLoginIp() != null) {
            SET("login_ip = #{loginIp,jdbcType=VARCHAR}");
        }

        if (record.getLoginDate() != null) {
            SET("login_date = #{loginDate,jdbcType=TIMESTAMP}");
        }

        if (record.getLoginFlag() != null) {
            SET("login_flag = #{loginFlag,jdbcType=VARCHAR}");
        }

        if (record.getCreateBy() != null) {
            SET("create_by = #{createBy,jdbcType=VARCHAR}");
        }

        if (record.getCreateDate() != null) {
            SET("create_date = #{createDate,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateBy() != null) {
            SET("update_by = #{updateBy,jdbcType=VARCHAR}");
        }

        if (record.getUpdateDate() != null) {
            SET("update_date = #{updateDate,jdbcType=TIMESTAMP}");
        }

        if (record.getRemarks() != null) {
            SET("remarks = #{remarks,jdbcType=VARCHAR}");
        }

        if (record.getDelFlag() != null) {
            SET("del_flag = #{delFlag,jdbcType=CHAR}");
        }

        WHERE("id = #{id,jdbcType=VARCHAR}");

        return SQL();
    }

    public String selectByExample(UserEntity userEntity) {

        BEGIN();
        //SELECT_DISTINCT("id");
        SELECT("id");
        SELECT("company_id");
        SELECT("office_id");
        SELECT("login_name");
        SELECT("password");
        SELECT("no");
        SELECT("name");
        SELECT("email");
        SELECT("phone");
        SELECT("mobile");
        SELECT("user_type");
        SELECT("photo");
        SELECT("login_ip");
        SELECT("login_date");
        SELECT("login_flag");
        SELECT("create_by");
        SELECT("create_date");
        SELECT("update_by");
        SELECT("update_date");
        SELECT("remarks");
        SELECT("del_flag");
        FROM("sys_user");
        /*WHERE("1=1");
        if (userEntity.getName() != null) {
            WHERE("name=#{userEntity.name,jdbcType=VARCHAR}");
            //AND();
            //strWhere.append(" and name=#{userEntity.name,jdbcType=VARCHAR}");
        }if(userEntity.getId()!=null){
            WHERE("name=#{userEntity.id,jdbcType=VARCHAR}");
        }*/
        return SQL();
        //return "select * from sys_user where name= #{name}";
    }

}