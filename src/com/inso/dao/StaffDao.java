package com.inso.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.inso.entity.Staff;



/**
 * 员工
 * @author MH·J
 *
 */
public interface StaffDao {


	
    @Delete({
        "delete from staff",
        "where st_id = #{stId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer stId);


    
    @Delete({
    	"<script>",
	        "delete from staff",
	        "where st_id in",
		        "<foreach collection='datas' item='id' open='(' separator=',' close=')'>",
		        "#{id}",
		        "</foreach>",
        "</script>"
    })
    int deleteByAll(@Param("datas")int[] datas);

   

    
    @Insert({
        "insert into staff (st_id, st_Grade, ",
        "st_ordernum, st_birth, st_Age, ",
        "st_phone1, st_phone2, st_name, st_password, ",
        "st_sex, st_ids, st_creatTime, st_updateTime, st_department, sa_id)",
        "values (#{stId,jdbcType=INTEGER}, #{stGrade,jdbcType=INTEGER}, ",
        "#{stOrdernum,jdbcType=BIGINT}, #{stBirth,jdbcType=TIMESTAMP}, #{stAge,jdbcType=INTEGER},",
        "#{stPhone1,jdbcType=BIGINT}, #{stPhone2,jdbcType=BIGINT}, #{stName,jdbcType=VARCHAR}, #{stPassword,jdbcType=VARCHAR}, ",
        "#{stSex,jdbcType=VARCHAR}, #{stIds,jdbcType=BIGINT}, #{stCreatTime,jdbcType=TIMESTAMP}, #{stUpdateTime,jdbcType=TIMESTAMP}, #{stDepartment,jdbcType=VARCHAR}, #{saId,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "stId", keyColumn = "st_id")
    int insert(Staff staff);






    @Select({
        "select",
        "st_id, st_Grade, st_ordernum, st_birth, st_Age, st_phone1, st_phone2, st_name, st_password, st_sex, st_ids, st_department, st_creatTime, st_updateTime, sa_id",
        "from staff",
        "where st_id = #{stId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="st_id", property="stId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="st_Grade", property="stGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="st_ordernum", property="stOrdernum", jdbcType=JdbcType.BIGINT),
        @Result(column="st_birth", property="stBirth", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="st_Age", property="stAge", jdbcType=JdbcType.INTEGER),
        @Result(column="st_phone1", property="stPhone1", jdbcType=JdbcType.BIGINT),
        @Result(column="st_phone2", property="stPhone2", jdbcType=JdbcType.BIGINT),
        @Result(column="st_name", property="stName", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_password", property="stPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_sex", property="stSex", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_ids", property="stIds", jdbcType=JdbcType.BIGINT),
        @Result(column="st_department", property="stDepartment", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_creatTime", property="stCreatTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="st_updateTime", property="stUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sa_id", property="saId", jdbcType=JdbcType.INTEGER)
    })
    Staff selectByPrimaryKey(Integer stId);


    /**
     * 根据员工姓名和密码查询员工
     * @param stName
     * @param stPassword
     * @return
     */
    @Select({
        "select",
        "st_id, st_Grade, st_ordernum, st_birth, st_Age, st_phone1, st_phone2, st_name, st_password, st_sex, st_ids, st_department, st_creatTime, st_updateTime, sa_id",
        "from staff",
        "where st_name = #{stName,jdbcType=VARCHAR} and st_password = #{stPassword,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="st_id", property="stId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="st_Grade", property="stGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="st_ordernum", property="stOrdernum", jdbcType=JdbcType.BIGINT),
        @Result(column="st_birth", property="stBirth", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="st_Age", property="stAge", jdbcType=JdbcType.INTEGER),
        @Result(column="st_phone1", property="stPhone1", jdbcType=JdbcType.BIGINT),
        @Result(column="st_phone2", property="stPhone2", jdbcType=JdbcType.BIGINT),
        @Result(column="st_name", property="stName", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_password", property="stPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_sex", property="stSex", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_ids", property="stIds", jdbcType=JdbcType.BIGINT),
        @Result(column="st_department", property="stDepartment", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_creatTime", property="stCreatTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="st_updateTime", property="stUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sa_id", property="saId", jdbcType=JdbcType.INTEGER)
    })
    Staff selectByNameAndPassword(@Param("stName") String stName,@Param("stPassword") String stPassword);

    /**
     * 查询所有员工信息
     * @return
     */
    @Select({
        "select",
        "st_id, st_Grade, st_ordernum, st_birth, st_Age, st_phone1, st_phone2, st_name, st_password, st_sex, st_ids, st_department, st_creatTime, st_updateTime, sa_id",
        "from staff"
    })
    @Results({
    	@Result(column="st_id", property="stId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="st_Grade", property="stGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="st_ordernum", property="stOrdernum", jdbcType=JdbcType.BIGINT),
        @Result(column="st_birth", property="stBirth", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="st_Age", property="stAge", jdbcType=JdbcType.INTEGER),
        @Result(column="st_phone1", property="stPhone1", jdbcType=JdbcType.BIGINT),
        @Result(column="st_phone2", property="stPhone2", jdbcType=JdbcType.BIGINT),
        @Result(column="st_name", property="stName", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_password", property="stPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_sex", property="stSex", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_ids", property="stIds", jdbcType=JdbcType.BIGINT),
        @Result(column="st_department", property="stDepartment", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_creatTime", property="stCreatTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="st_updateTime", property="stUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sa_id", property="saId", jdbcType=JdbcType.INTEGER)
    })
    List<Staff> selectAllStaff();
    

    
    /**
     * 查询权限比自身低的员工信息
     * @return
     */
    @Select({
        "select",
        "st_id, st_Grade, st_ordernum, st_birth, st_Age, st_phone1, st_phone2, st_name, st_password, st_sex, st_ids, st_department, st_creatTime, st_updateTime, sa_id",
        "from staff",
        "where st_Grade > #{stGrade,jdbcType=INTEGER}"
    })
    @Results({
    	@Result(column="st_id", property="stId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="st_Grade", property="stGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="st_ordernum", property="stOrdernum", jdbcType=JdbcType.BIGINT),
        @Result(column="st_birth", property="stBirth", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="st_Age", property="stAge", jdbcType=JdbcType.INTEGER),
        @Result(column="st_phone1", property="stPhone1", jdbcType=JdbcType.BIGINT),
        @Result(column="st_phone2", property="stPhone2", jdbcType=JdbcType.BIGINT),
        @Result(column="st_name", property="stName", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_password", property="stPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_sex", property="stSex", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_ids", property="stIds", jdbcType=JdbcType.BIGINT),
        @Result(column="st_department", property="stDepartment", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_creatTime", property="stCreatTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="st_updateTime", property="stUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sa_id", property="saId", jdbcType=JdbcType.INTEGER)
    })
    List<Staff> selectStaffGrade(int stGrade);

    
  // 模糊查询，使用 CONCAT('%',#{param},'%')
    @Select({
    	"select",
        "st_id, st_Grade, st_ordernum, st_birth, st_Age, st_phone1, st_phone2, st_name, st_password, st_sex, st_ids, st_department, st_creatTime, st_updateTime, sa_id",
        " from staff ",
        "where  st_name like #{stName,jdbcType=VARCHAR}"
    })
    @Results({
    	@Result(column="st_id", property="stId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="st_Grade", property="stGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="st_ordernum", property="stOrdernum", jdbcType=JdbcType.BIGINT),
        @Result(column="st_birth", property="stBirth", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="st_Age", property="stAge", jdbcType=JdbcType.INTEGER),
        @Result(column="st_phone1", property="stPhone1", jdbcType=JdbcType.BIGINT),
        @Result(column="st_phone2", property="stPhone2", jdbcType=JdbcType.BIGINT),
        @Result(column="st_name", property="stName", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_password", property="stPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_sex", property="stSex", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_ids", property="stIds", jdbcType=JdbcType.BIGINT),
        @Result(column="st_department", property="stDepartment", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_creatTime", property="stCreatTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="st_updateTime", property="stUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sa_id", property="saId", jdbcType=JdbcType.INTEGER)
    })
    public List<Staff> retrieveUserByIdAndName(String stName);

    
    
    
    
    @Select({
    	"select",
        "st_id, st_Grade, st_ordernum, st_birth, st_Age, st_phone1, st_phone2, st_name, st_password, st_sex, st_ids, st_department, st_creatTime, st_updateTime, sa_id",
        " from staff ",
        "where  st_ordernum = #{stOrdernum,jdbcType=BIGINT} "
    })
    @Results({
    	@Result(column="st_id", property="stId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="st_Grade", property="stGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="st_ordernum", property="stOrdernum", jdbcType=JdbcType.BIGINT),
        @Result(column="st_birth", property="stBirth", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="st_Age", property="stAge", jdbcType=JdbcType.INTEGER),
        @Result(column="st_phone1", property="stPhone1", jdbcType=JdbcType.BIGINT),
        @Result(column="st_phone2", property="stPhone2", jdbcType=JdbcType.BIGINT),
        @Result(column="st_name", property="stName", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_password", property="stPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_sex", property="stSex", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_ids", property="stIds", jdbcType=JdbcType.BIGINT),
        @Result(column="st_department", property="stDepartment", jdbcType=JdbcType.VARCHAR),
        @Result(column="st_creatTime", property="stCreatTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="st_updateTime", property="stUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sa_id", property="saId", jdbcType=JdbcType.INTEGER)
    })
    public List<Staff> retrieveUserBystOrdernum(Long stOrdernum);
    
    
    @UpdateProvider(type=StaffDaoProvider.class,method="updateByPrimaryKey") 
    int updateByPrimaryKey(Staff staff);
    
    class StaffDaoProvider {  
        public String updateByPrimaryKey(Staff staff) {  
 
            String sql =  "update staff set ";
            if(staff.getStGrade()!=null){  
                sql += "st_Grade = #{stGrade,jdbcType=INTEGER},";  
            }  
            
            if(staff.getStOrdernum()!=null){  
                sql += "st_ordernum = #{stOrdernum,jdbcType=BIGINT},";  
            }  
              
              if(staff.getStBirth()!=null){  
                  sql += "st_birth = #{stBirth,jdbcType=TIMESTAMP},";  
              }  
              
              if(staff.getStAge()!=null){  
                  sql += "st_Age = #{stAge,jdbcType=INTEGER},";  
              }  
              
              if(staff.getStPhone1()!=null){  
                  sql += "st_phone1 = #{stPhone1,jdbcType=BIGINT},";  
              }  
              
              if(staff.getStPhone2()!=null){  
                  sql += "st_phone2 = #{stPhone2,jdbcType=BIGINT},";  
              }  
              
 
              
              if(staff.getStPassword()!=null){  
                  sql += "st_password = #{stPassword,jdbcType=VARCHAR},";  
              }  
              
              if(staff.getStSex()!=null){  
                  sql += "st_sex = #{stSex,jdbcType=VARCHAR},";  
              }  
              
              if(staff.getStIds()!=null){  
                  sql += "st_ids = #{stIds,jdbcType=BIGINT},";  
              }  
              
              if(staff.getStDepartment()!=null){  
                  sql += "st_department = #{stDepartment,jdbcType=VARCHAR},";  
              }  
              
              if(staff.getStCreatTime()!=null){  
                  sql += "st_creatTime = #{stCreatTime,jdbcType=TIMESTAMP},";  
              }  
              
              if(staff.getStUpdateTime()!=null){  
                  sql += "st_updateTime = #{stUpdateTime,jdbcType=TIMESTAMP},";  
              }  
              
              if(staff.getSaId()!=null){  
                  sql += "sa_id = #{saId,jdbcType=INTEGER},";  
              }  
           
              if(staff.getStName()!=null){  
                  sql += "st_name = #{stName,jdbcType=VARCHAR}";  
              } 
              
              sql +=  " where st_id = #{stId,jdbcType=INTEGER}";  

            return sql;  
        }  
    }  
    
    
}