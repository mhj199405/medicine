package com.inso.dao;

import java.util.List;

import com.inso.entity.Refund;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface RefundDao {
   
    @Delete({
        "delete from charge",
        "where charge_id = #{chargeId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer chargeId);
    
 
    
    @Delete({
    	"<script>",
	        "delete from charge",
	        "where charge_id in",
		        "<foreach collection='datas' item='id' open='(' separator=',' close=')'>",
		        "#{id}",
		        "</foreach>",
        "</script>"
    })
    int deleteByAll(@Param("datas")int[] datas);

   
    @Insert({
        "insert into charge (charge_id, solder_name, ",
        "charge_time, charge_reason, ",
        "charge_number)",
        "values (#{chargeId,jdbcType=INTEGER}, #{solderName,jdbcType=VARCHAR}, ",
        "#{chargeTime,jdbcType=TIMESTAMP}, #{chargeReason,jdbcType=VARCHAR}, ",
        "#{chargeNumber,jdbcType=INTEGER})"
    })
    int insert(Refund record);

   
    /**
     * 查询单个退单
     * @param chargeId
     * @return
     */
    @Select({
        "select",
        "charge_id, solder_name, charge_time, charge_reason, charge_number",
        "from charge",
        "where charge_id = #{chargeId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="charge_id", property="chargeId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="solder_name", property="solderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="charge_time", property="chargeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="charge_reason", property="chargeReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="charge_number", property="chargeNumber", jdbcType=JdbcType.INTEGER)
    })
    Refund selectByPrimaryKey(Integer chargeId);

    
   
    /**
     * 查询所有退单
     * @param chargeId
     * @return
     */
    @Select({
        "select",
        "charge_id, solder_name, charge_time, charge_reason, charge_number",
        "from charge"
    })
    @Results({
        @Result(column="charge_id", property="chargeId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="solder_name", property="solderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="charge_time", property="chargeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="charge_reason", property="chargeReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="charge_number", property="chargeNumber", jdbcType=JdbcType.INTEGER)
    })
    List<Refund> selectAllCharge();
    
    
    
    /**
     * 模糊查询单个退单
     * @param chargeId
     * @return
     */
    @Select({
        "select",
        "charge_id, solder_name, charge_time, charge_reason, charge_number",
        "from charge",
        "where  solder_name like #{solderName,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="charge_id", property="chargeId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="solder_name", property="solderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="charge_time", property="chargeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="charge_reason", property="chargeReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="charge_number", property="chargeNumber", jdbcType=JdbcType.INTEGER)
    })
    List<Refund> selectBysolderName(String solderName);

    
   
    @Update({
        "update charge",
        "set solder_name = #{solderName,jdbcType=VARCHAR},",
          "charge_time = #{chargeTime,jdbcType=TIMESTAMP},",
          "charge_reason = #{chargeReason,jdbcType=VARCHAR},",
          "charge_number = #{chargeNumber,jdbcType=INTEGER}",
        "where charge_id = #{chargeId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Refund record);
}