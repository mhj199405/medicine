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

import com.inso.entity.IntoMan;

public interface IntoManDao {
    
	
	
    @Delete({
        "delete from into_man",
        "where into_id = #{intoId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer intoId);

    
    @Delete({
    	"<script>",
	        "delete from into_man",
	        "where into_id in",
		        "<foreach collection='datas' item='id' open='(' separator=',' close=')'>",
		        "#{id}",
		        "</foreach>",
        "</script>"
    })
    int deleteByAll(@Param("datas")int[] datas);
    
    
    
    @Insert({
        "insert into into_man (into_id, into_name, ",
        "into_type, into_number,into_price ,into_createTime)",
        "values (#{intoId,jdbcType=INTEGER}, #{intoName,jdbcType=VARCHAR}, ",
        "#{intoType,jdbcType=VARCHAR}, #{intoNumber,jdbcType=INTEGER},#{intoPrice,jdbcType=DECIMAL},#{intoCreateTime,jdbcType=TIMESTAMP})"
    })
    int insert(IntoMan record);

    
    

   
    @Select({
        "select",
        "into_id, into_name, into_type, into_number,into_price ,into_createTime",
        "from into_man",
        "where into_id = #{intoId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="into_id", property="intoId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="into_name", property="intoName", jdbcType=JdbcType.VARCHAR),
        @Result(column="into_type", property="intoType", jdbcType=JdbcType.VARCHAR),
        @Result(column="into_number", property="intoNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="into_price", property="intoPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="into_createTime", property="intoCreateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    IntoMan selectByPrimaryKey(Integer intoId);

   
    @Select({
        "select",
        "into_id, into_name, into_type, into_number,into_price ,into_createTime",
        "from into_man",
    })
    @Results({
        @Result(column="into_id", property="intoId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="into_name", property="intoName", jdbcType=JdbcType.VARCHAR),
        @Result(column="into_type", property="intoType", jdbcType=JdbcType.VARCHAR),
        @Result(column="into_number", property="intoNumber", jdbcType=JdbcType.INTEGER),
         @Result(column="into_price", property="intoPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="into_createTime", property="intoCreateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<IntoMan> selectAllIntoMan();
    
    
    @Select({
        "select",
        "into_id, into_name, into_type, into_number,into_price ,into_createTime",
        "from into_man",
        "where  into_name like #{intoName,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="into_id", property="intoId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="into_name", property="intoName", jdbcType=JdbcType.VARCHAR),
        @Result(column="into_type", property="intoType", jdbcType=JdbcType.VARCHAR),
        @Result(column="into_number", property="intoNumber", jdbcType=JdbcType.INTEGER),
         @Result(column="into_price", property="intoPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="into_createTime", property="intoCreateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<IntoMan> selectByintoName(String intoName);
    


    @Update({
        "update into_man",
        "set into_name = #{intoName,jdbcType=VARCHAR},",
          "into_type = #{intoType,jdbcType=VARCHAR},",
          "into_number = #{intoNumber,jdbcType=INTEGER},",
          "into_price = #{intoPrice,jdbcType=DECIMAL},",
          "into_createTime = #{intoCreateTime,jdbcType=TIMESTAMP} ",
        "where into_id = #{intoId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(IntoMan record);
}