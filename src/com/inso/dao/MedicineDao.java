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

import com.inso.entity.Medicine;

public interface MedicineDao {


	
    @Delete({
        "delete from medicine",
        "where m_id = #{mId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer mId);


    @Delete({
    	"<script>",
	        "delete from medicine",
	        "where m_id in",
		        "<foreach collection='datas' item='id' open='(' separator=',' close=')'>",
		        "#{id}",
		        "</foreach>",
        "</script>"
    })
    int deleteByAll(@Param("datas")int[] datas);
    

    @Insert({
        "insert into medicine (m_id,med_name, price, ",
        "med_num, prouduct_date, ",
        "save_date, producter, ",
        "prouduct_area, phone, ",
        "careat_time, update_time)",
        "values (#{mId,jdbcType=INTEGER}, #{medName,jdbcType=VARCHAR}, #{price,jdbcType=DECIMAL}, ",
        "#{medNum,jdbcType=INTEGER}, #{prouductDate,jdbcType=TIMESTAMP}, ",
        "#{saveDate,jdbcType=TIMESTAMP}, #{producter,jdbcType=VARCHAR}, ",
        "#{prouductArea,jdbcType=VARCHAR}, #{phone,jdbcType=BIGINT}, ",
        "#{careatTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Medicine record);

    /**
     * 查询单个药品
     * @param mId
     * @return
     */
    @Select({
        "select",
        "m_id, med_name, price, med_num, prouduct_date, save_date, producter, prouduct_area, phone, ",
        "careat_time, update_time",
        "from medicine",
        "where m_id = #{mId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="m_id", property="mId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="med_name", property="medName", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="med_num", property="medNum", jdbcType=JdbcType.INTEGER),
        @Result(column="prouduct_date", property="prouductDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="save_date", property="saveDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="producter", property="producter", jdbcType=JdbcType.VARCHAR),
        @Result(column="prouduct_area", property="prouductArea", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.BIGINT),
        @Result(column="careat_time", property="careatTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Medicine selectByPrimaryKey(Integer mId);


    /**
     * 查询全部药品
     * @param
     * @return
     */
    @Select({
        "select",
        "m_id,med_name, price, med_num, prouduct_date, save_date, producter, prouduct_area, phone, ",
        "careat_time, update_time",
        "from medicine order by m_id DESC"
    })
    @Results({
        @Result(column="m_id", property="mId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="med_name", property="medName", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="med_num", property="medNum", jdbcType=JdbcType.INTEGER),
        @Result(column="prouduct_date", property="prouductDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="save_date", property="saveDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="producter", property="producter", jdbcType=JdbcType.VARCHAR),
        @Result(column="prouduct_area", property="prouductArea", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.BIGINT),
        @Result(column="careat_time", property="careatTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Medicine>  selectAllMedicine();


    /**
     * 查询单个药品根据药品名
     * @param
     * @return
     */
    @Select({
        "select",
        "m_id,med_name, price, med_num, prouduct_date, save_date, producter, prouduct_area, phone, ",
        "careat_time, update_time",
        "from medicine",
        "where  med_name like #{medName,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="m_id", property="mId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="med_name", property="medName", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="med_num", property="medNum", jdbcType=JdbcType.INTEGER),
        @Result(column="prouduct_date", property="prouductDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="save_date", property="saveDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="producter", property="producter", jdbcType=JdbcType.VARCHAR),
        @Result(column="prouduct_area", property="prouductArea", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.BIGINT),
        @Result(column="careat_time", property="careatTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Medicine>  selectBymedName(String medName);
    
    
    
    @Update({
        "update medicine",
        "set med_name = #{medName,jdbcType=VARCHAR}, price = #{price,jdbcType=DECIMAL},",
          "med_num = #{medNum,jdbcType=INTEGER},",
          "prouduct_date = #{prouductDate,jdbcType=TIMESTAMP},",
          "save_date = #{saveDate,jdbcType=TIMESTAMP},",
          "producter = #{producter,jdbcType=VARCHAR},",
          "prouduct_area = #{prouductArea,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=BIGINT},",
          "careat_time = #{careatTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where m_id = #{mId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Medicine record);

}