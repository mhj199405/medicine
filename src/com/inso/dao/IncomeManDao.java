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

import com.inso.entity.IncomeMan;

/**
 * 收入管理
 * @author MH·J
 *
 */
public interface IncomeManDao {
   
	
    @Delete({
        "delete from income_man",
        "where in_id = #{inId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer inId);

 
    @Delete({
    	"<script>",
	        "delete from income_man",
	        "where in_id in",
		        "<foreach collection='datas' item='id' open='(' separator=',' close=')'>",
		        "#{id}",
		        "</foreach>",
        "</script>"
    })
    int deleteByAll(@Param("datas")int[] datas);

    
    
    
    @Insert({
        "insert into income_man (in_id, in_name, ",
        "in_number, in_ordernum, ",
        "in_pay, in_card , in_cashier, in_createTime)",
        "values (#{inId,jdbcType=INTEGER}, #{inName,jdbcType=VARCHAR}, ",
        "#{inNumber,jdbcType=INTEGER}, #{inOrdernum,jdbcType=INTEGER}, ",
        "#{inPay,jdbcType=VARCHAR}, #{inCard,jdbcType=INTEGER},#{inCashier,jdbcType=VARCHAR},#{inCreateTime,jdbcType=TIMESTAMP})"
    })
    int insert(IncomeMan record);

    

   
    
    @Select({
        "select",
        "in_id, in_name, in_number, in_ordernum, in_pay, in_card, in_cashier, in_createTime",
        "from income_man",
        "where in_id = #{inId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="in_id", property="inId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="in_name", property="inName", jdbcType=JdbcType.VARCHAR),
        @Result(column="in_number", property="inNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="in_ordernum", property="inOrdernum", jdbcType=JdbcType.INTEGER),
        @Result(column="in_pay", property="inPay", jdbcType=JdbcType.VARCHAR),
        @Result(column="in_card", property="inCard", jdbcType=JdbcType.INTEGER),
        @Result(column="in_cashier", property="inCashier", jdbcType=JdbcType.VARCHAR),
        @Result(column="in_createTime", property="inCreateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    IncomeMan selectByPrimaryKey(Integer inId);

    

    @Select({
        "select",
        "in_id, in_name, in_number, in_ordernum, in_pay, in_card, in_cashier, in_createTime",
        "from income_man",
    })
    @Results({
        @Result(column="in_id", property="inId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="in_name", property="inName", jdbcType=JdbcType.VARCHAR),
        @Result(column="in_number", property="inNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="in_ordernum", property="inOrdernum", jdbcType=JdbcType.INTEGER),
        @Result(column="in_pay", property="inPay", jdbcType=JdbcType.VARCHAR),
        @Result(column="in_card", property="inCard", jdbcType=JdbcType.INTEGER),
        @Result(column="in_cashier", property="inCashier", jdbcType=JdbcType.VARCHAR),
        @Result(column="in_createTime", property="inCreateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<IncomeMan> selectAllIncomeMan();
    
    
    
    @Select({
        "select",
        "in_id, in_name, in_number, in_ordernum, in_pay, in_card, in_cashier, in_createTime",
        "from income_man",
        "where  in_name like #{inName,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="in_id", property="inId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="in_name", property="inName", jdbcType=JdbcType.VARCHAR),
        @Result(column="in_number", property="inNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="in_ordernum", property="inOrdernum", jdbcType=JdbcType.INTEGER),
        @Result(column="in_pay", property="inPay", jdbcType=JdbcType.VARCHAR),
        @Result(column="in_card", property="inCard", jdbcType=JdbcType.INTEGER),
        @Result(column="in_cashier", property="inCashier", jdbcType=JdbcType.VARCHAR),
        @Result(column="in_createTime", property="inCreateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<IncomeMan> selectByinName(String inName);
    
    


    @Update({
        "update income_man",
        "set in_name = #{inName,jdbcType=VARCHAR},",
          "in_number = #{inNumber,jdbcType=INTEGER},",
          "in_ordernum = #{inOrdernum,jdbcType=INTEGER},",
          "in_pay = #{inPay,jdbcType=VARCHAR},",
          "in_card = #{inCard,jdbcType=INTEGER},",
          "in_cashier = #{inCashier,jdbcType=VARCHAR},",
          "in_createTime = #{inCreateTime,jdbcType=TIMESTAMP} ",
        "where in_id = #{inId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(IncomeMan record);


    @Select("SELECT COUNT(*) as num FROM income_man m  where m.in_pay= #{inPay}")
    Integer countByCount(String inPay);
}