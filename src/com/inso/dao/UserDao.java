package com.inso.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.inso.entity.User;

public interface UserDao {

    @Delete({
        "delete from user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);
    
    
    
    @Delete({
    	"<script>",
	        "delete from user",
	        "where user_id in",
		        "<foreach collection='datas' item='id' open='(' separator=',' close=')'>",
		        "#{id}",
		        "</foreach>",
        "</script>"
    })
    int deleteByAll(@Param("datas")int[] datas);
    
    

    @Insert({
        "insert into user (user_id, user_name, ",
        "member_dengji, birth, ",
        "user_phone, user_address, ",
        "balance, point, ",
        "Records, state, ",
        "Recharge, user_money)",
        "values (#{userId,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR}, ",
        "#{memberDengji,jdbcType=INTEGER}, #{birth,jdbcType=TIMESTAMP}, ",
        "#{userPhone,jdbcType=BIGINT}, #{userAddress,jdbcType=VARCHAR}, ",
        "#{balance,jdbcType=DECIMAL}, #{point,jdbcType=INTEGER}, ",
        "#{records,jdbcType=VARCHAR}, #{state,jdbcType=INTEGER}, ",
        "#{recharge,jdbcType=TIMESTAMP}, #{userMoney,jdbcType=DECIMAL})"
    })
    int insert(User record);


    @Select({
        "select",
        "user_id, user_name, member_dengji, birth, user_phone, user_address, balance, ",
        "point, Records, state, Recharge, user_money",
        "from user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="member_dengji", property="memberDengji", jdbcType=JdbcType.INTEGER),
        @Result(column="birth", property="birth", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_phone", property="userPhone", jdbcType=JdbcType.INTEGER),
        @Result(column="user_address", property="userAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="balance", property="balance", jdbcType=JdbcType.DECIMAL),
        @Result(column="point", property="point", jdbcType=JdbcType.INTEGER),
        @Result(column="Records", property="records", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="Recharge", property="recharge", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_money", property="userMoney", jdbcType=JdbcType.DECIMAL)
    })
    User selectByPrimaryKey(Integer userId);




    @Select({
        "select",
        "user_id, user_name, member_dengji, birth, user_phone, user_address, balance, ",
        "point, Records, state, Recharge, user_money",
        "from user",
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="member_dengji", property="memberDengji", jdbcType=JdbcType.INTEGER),
        @Result(column="birth", property="birth", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_phone", property="userPhone", jdbcType=JdbcType.BIGINT),
        @Result(column="user_address", property="userAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="balance", property="balance", jdbcType=JdbcType.DECIMAL),
        @Result(column="point", property="point", jdbcType=JdbcType.INTEGER),
        @Result(column="Records", property="records", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="Recharge", property="recharge", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_money", property="userMoney", jdbcType=JdbcType.DECIMAL)
    })
    List<User> selectAllUser();
    
    
    

    @Select({
        "select",
        "user_id, user_name, member_dengji, birth, user_phone, user_address, balance, ",
        "point, Records, state, Recharge, user_money",
        "from user",
        "where  user_name like #{userName,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="member_dengji", property="memberDengji", jdbcType=JdbcType.INTEGER),
        @Result(column="birth", property="birth", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_phone", property="userPhone", jdbcType=JdbcType.BIGINT),
        @Result(column="user_address", property="userAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="balance", property="balance", jdbcType=JdbcType.DECIMAL),
        @Result(column="point", property="point", jdbcType=JdbcType.INTEGER),
        @Result(column="Records", property="records", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="Recharge", property="recharge", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_money", property="userMoney", jdbcType=JdbcType.DECIMAL)
    })
    List<User> selectByuserName(String userName);
    
    
    

    @Update({
        "update user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "member_dengji = #{memberDengji,jdbcType=INTEGER},",
          "birth = #{birth,jdbcType=TIMESTAMP},",
          "user_phone = #{userPhone,jdbcType=BIGINT},",
          "user_address = #{userAddress,jdbcType=VARCHAR},",
          "balance = #{balance,jdbcType=DECIMAL},",
          "point = #{point,jdbcType=INTEGER},",
          "Records = #{records,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=INTEGER},",
          "Recharge = #{recharge,jdbcType=TIMESTAMP},",
          "user_money = #{userMoney,jdbcType=DECIMAL}",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}