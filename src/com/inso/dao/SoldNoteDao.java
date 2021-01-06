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

import com.inso.entity.SoldNote;

public interface SoldNoteDao {


	
    @Delete({
        "delete from sold_note",
        "where sold_id = #{soldId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer soldId);


    @Delete({
    	"<script>",
	        "delete from sold_note",
	        "where sold_id in",
		        "<foreach collection='datas' item='id' open='(' separator=',' close=')'>",
		        "#{id}",
		        "</foreach>",
        "</script>"
    })
    int deleteByAll(@Param("datas")int[] datas);
    
    
    @Insert({
        "insert into sold_note (sold_id, solder_name, ",
        "sold_time, order_id, ",
        "customer_name)",
        "values (#{soldId,jdbcType=INTEGER}, #{solderName,jdbcType=VARCHAR}, ",
        "#{soldTime,jdbcType=TIMESTAMP}, #{orderId,jdbcType=BIGINT}, ",
        "#{customerName,jdbcType=VARCHAR})"
    })
    int insert(SoldNote record);






    
    @Select({
        "select",
        "sold_id, solder_name, sold_time, order_id, customer_name",
        "from sold_note",
        "where sold_id = #{soldId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="sold_id", property="soldId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="solder_name", property="solderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sold_time", property="soldTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR)
    })
    SoldNote selectByPrimaryKey(Integer soldId);



    @Select({
        "select",
        "sold_id, solder_name, sold_time, order_id, customer_name",
        "from sold_note",
    })
    @Results({
        @Result(column="sold_id", property="soldId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="solder_name", property="solderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sold_time", property="soldTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR)
    })
    List<SoldNote> selectAllSoldNote();

    
    /**
     * 模糊查询
     * @return
     */
    @Select({
        "select",
        "sold_id, solder_name, sold_time, order_id, customer_name",
        "from sold_note",
        "where  solder_name like #{solderName,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="sold_id", property="soldId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="solder_name", property="solderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sold_time", property="soldTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR)
    })
    List<SoldNote> selectBysolderName(String solderName);


    @Update({
        "update sold_note",
        "set solder_name = #{solderName,jdbcType=VARCHAR},",
          "sold_time = #{soldTime,jdbcType=TIMESTAMP},",
          "order_id = #{orderId,jdbcType=BIGINT},",
          "customer_name = #{customerName,jdbcType=VARCHAR}",
        "where sold_id = #{soldId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SoldNote record);
}