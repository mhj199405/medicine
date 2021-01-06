package com.inso.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.inso.entity.SalaryMan;
import com.inso.entity.Staff;

public interface SalaryManDao {


	
    @Delete({
        "delete from salary_man",
        "where sa_id = #{saId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer saId);

    
    
	
    @Delete({
        "delete from salary_man",
        "where st_id = #{stId,jdbcType=INTEGER}"
    })
    int deleteByStId(Integer stId);
    
    
    @Delete({
    	"<script>",
	        "delete from salary_man",
	        "where st_id in",
		        "<foreach collection='datas' item='id' open='(' separator=',' close=')'>",
		        "#{id}",
		        "</foreach>",
        "</script>"
    })
    int deleteByAllByStIds(@Param("datas")int[] datas);

    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salary_man
     *
     * @mbggenerated Sat Nov 17 15:31:40 CST 2018
     */
    @Insert({
        "insert into salary_man (sa_id, sa_number, ",
        "sa_overtime, sa_chidao, ",
        "sa_zaotui, sa_lastSalary, ",
        "st_id)",
        "values (#{saId,jdbcType=INTEGER}, #{saNumber,jdbcType=DECIMAL}, ",
        "#{saOvertime,jdbcType=VARCHAR}, #{saChidao,jdbcType=VARCHAR}, ",
        "#{saZaotui,jdbcType=VARCHAR}, #{saLastsalary,jdbcType=DECIMAL}, ",
        "#{stId,jdbcType=INTEGER})"
    })
    int insert(SalaryMan record);




    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salary_man
     *
     * @mbggenerated Sat Nov 17 15:31:40 CST 2018
     */
    @Select({
        "select",
        "sa_id, sa_number, sa_overtime, sa_chidao, sa_zaotui, sa_lastSalary, st_id",
        "from salary_man",
        "where sa_id = #{saId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="sa_id", property="saId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sa_number", property="saNumber", jdbcType=JdbcType.DECIMAL),
        @Result(column="sa_overtime", property="saOvertime", jdbcType=JdbcType.VARCHAR),
        @Result(column="sa_chidao", property="saChidao", jdbcType=JdbcType.VARCHAR),
        @Result(column="sa_zaotui", property="saZaotui", jdbcType=JdbcType.VARCHAR),
        @Result(column="sa_lastSalary", property="saLastsalary", jdbcType=JdbcType.DECIMAL),
        @Result(column="st_id", property="stId", jdbcType=JdbcType.INTEGER)
    })
    SalaryMan selectByPrimaryKey(Integer saId);

    
    
    @Select({
        "select",
        "sa_id, sa_number, sa_overtime, sa_chidao, sa_zaotui, sa_lastSalary, st_id",
        "from salary_man",
        "where st_id = #{stId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="sa_id", property="saId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sa_number", property="saNumber", jdbcType=JdbcType.DECIMAL),
        @Result(column="sa_overtime", property="saOvertime", jdbcType=JdbcType.VARCHAR),
        @Result(column="sa_chidao", property="saChidao", jdbcType=JdbcType.VARCHAR),
        @Result(column="sa_zaotui", property="saZaotui", jdbcType=JdbcType.VARCHAR),
        @Result(column="sa_lastSalary", property="saLastsalary", jdbcType=JdbcType.DECIMAL),
        @Result(column="st_id", property="stId", jdbcType=JdbcType.INTEGER)
    })
    SalaryMan selectByStId(Integer stId);
    
    
    
    @Select({
        "select",
        "sa_id, sa_number, sa_overtime, sa_chidao, sa_zaotui, sa_lastSalary, st_id",
        "from salary_man"
    })
    @Results({
        @Result(column="sa_id", property="saId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sa_number", property="saNumber", jdbcType=JdbcType.DECIMAL),
        @Result(column="sa_overtime", property="saOvertime", jdbcType=JdbcType.VARCHAR),
        @Result(column="sa_chidao", property="saChidao", jdbcType=JdbcType.VARCHAR),
        @Result(column="sa_zaotui", property="saZaotui", jdbcType=JdbcType.VARCHAR),
        @Result(column="sa_lastSalary", property="saLastsalary", jdbcType=JdbcType.DECIMAL),
        @Result(column="st_id", property="stId", jdbcType=JdbcType.INTEGER),
        @Result(property="staff",javaType=Staff.class,column="st_id",
     	many=@Many(select="com.inso.dao.StaffDao.selectByPrimaryKey"))
    })
	List<SalaryMan> selectAllSalaryMan();
		
	
 /**
  * 模糊查询
  * @return
  */  
    @Select({
        "select * from salary_man sa, staff st where sa.st_id = st.st_id and st_name like #{stName,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="sa_id", property="saId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sa_number", property="saNumber", jdbcType=JdbcType.DECIMAL),
        @Result(column="sa_overtime", property="saOvertime", jdbcType=JdbcType.VARCHAR),
        @Result(column="sa_chidao", property="saChidao", jdbcType=JdbcType.VARCHAR),
        @Result(column="sa_zaotui", property="saZaotui", jdbcType=JdbcType.VARCHAR),
        @Result(column="sa_lastSalary", property="saLastsalary", jdbcType=JdbcType.DECIMAL),
        @Result(column="st_id", property="stId", jdbcType=JdbcType.INTEGER),
        @Result(property="staff",javaType=Staff.class,column="st_id",
     	many=@Many(select="com.inso.dao.StaffDao.selectByPrimaryKey"))
    })
	List<SalaryMan> selectAllSalaryManByLikeStName(String stName);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salary_man
     *
     * @mbggenerated
     */
    @UpdateProvider(type=StaffDaoProvider.class,method="updateByPrimaryKey") 
    int updateByPrimaryKey(SalaryMan record);
    
    
    
    class StaffDaoProvider {  
        public String updateByPrimaryKey(SalaryMan salaryMan) {  
 
            String sql =  "update salary_man  set ";

            if(salaryMan.getSaOvertime()!=null){  
                sql += "sa_overtime = #{saOvertime,jdbcType=VARCHAR},";  
            } 
            if(salaryMan.getSaChidao()!=null){  
            	sql +=  "sa_chidao = #{saChidao,jdbcType=VARCHAR},";  
            } 
            if(salaryMan.getSaZaotui()!=null){  
            	sql += "sa_zaotui = #{saZaotui,jdbcType=VARCHAR},";  
            } 
            if(salaryMan.getSaLastsalary()!=null){  
            	sql += "sa_lastSalary = #{saLastsalary,jdbcType=DECIMAL},";  
            } 
            if(salaryMan.getStId()!=null){  
            	sql +=  "st_id = #{stId,jdbcType=INTEGER},";  
            } 
            if(salaryMan.getSaNumber()!=null){  
                sql +=  "sa_number = #{saNumber,jdbcType=DECIMAL} ";  
            }  
            
            
            sql +=  " where sa_id = #{saId,jdbcType=INTEGER}";  
            return sql;  
        }  
    }  


    
    
}