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

import com.inso.entity.Provide;

/**
 * 供应商信息
 * @author MH·J
 *
 */
public interface ProvideDao {


	
    @Delete({
        "delete from provide",
        "where pro_id = #{proId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer proId);


    
    @Delete({
    	"<script>",
	        "delete from provide",
	        "where pro_id in",
		        "<foreach collection='datas' item='id' open='(' separator=',' close=')'>",
		        "#{id}",
		        "</foreach>",
        "</script>"
    })
    int deleteByAll(@Param("datas")int[] datas);

    

    @Insert({
        "insert into provide (pro_id, pro_name, ",
        "pro_num, med_type, ",
        "orders)",
        "values (#{proId,jdbcType=INTEGER}, #{proName,jdbcType=VARCHAR}, ",
        "#{proNum,jdbcType=BIGINT}, #{medType,jdbcType=VARCHAR}, ",
        "#{orders,jdbcType=VARCHAR})"
    })
    int insert(Provide record);





    @Select({
        "select",
        "pro_id, pro_name, pro_num, med_type, orders",
        "from provide",
        "where pro_id = #{proId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pro_name", property="proName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pro_num", property="proNum", jdbcType=JdbcType.BIGINT),
        @Result(column="med_type", property="medType", jdbcType=JdbcType.VARCHAR),
        @Result(column="orders", property="orders", jdbcType=JdbcType.VARCHAR)
    })
    Provide selectByPrimaryKey(Integer proId);


    /**
     * 查询全部供应商
     * @return
     */
    @Select({
        "select",
        "pro_id, pro_name, pro_num, med_type, orders",
        "from provide"
    })
    @Results({
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pro_name", property="proName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pro_num", property="proNum", jdbcType=JdbcType.BIGINT),
        @Result(column="med_type", property="medType", jdbcType=JdbcType.VARCHAR),
        @Result(column="orders", property="orders", jdbcType=JdbcType.VARCHAR)
    })
    List<Provide> selectAllProvide();



    /**
     * 模糊查询单个供应商根据供应商名称
     * @return
     */
    @Select({
        "select",
        "pro_id, pro_name, pro_num, med_type, orders",
        "from provide",
        "where  pro_name like #{proName,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pro_name", property="proName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pro_num", property="proNum", jdbcType=JdbcType.BIGINT),
        @Result(column="med_type", property="medType", jdbcType=JdbcType.VARCHAR),
        @Result(column="orders", property="orders", jdbcType=JdbcType.VARCHAR)
    })
    List<Provide> selectByproName(String proName);
    
    
    @Update({
        "update provide",
        "set pro_name = #{proName,jdbcType=VARCHAR},",
          "pro_num = #{proNum,jdbcType=BIGINT},",
          "med_type = #{medType,jdbcType=VARCHAR},",
          "orders = #{orders,jdbcType=VARCHAR}",
        "where pro_id = #{proId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Provide record);
}