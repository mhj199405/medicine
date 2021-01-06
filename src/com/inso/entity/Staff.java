package com.inso.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Staff implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	
	private Integer stId;
    private String stName;
    private Long stOrdernum;    
    private String stSex;
    private Integer stGrade;
    private Timestamp stBirth;
    private Integer stAge;
    private Long stPhone1;   
    private Long stPhone2;    
    private Long stIds;
    private String stDepartment;   
    private Integer saId;
    private String stPassword;      
    private Timestamp stCreatTime;    
    private Timestamp stUpdateTime;
	public Integer getStId() {
		return stId;
	}
	public void setStId(Integer stId) {
		this.stId = stId;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public Long getStOrdernum() {
		return stOrdernum;
	}
	public void setStOrdernum(Long stOrdernum) {
		this.stOrdernum = stOrdernum;
	}
	public String getStSex() {
		return stSex;
	}
	public void setStSex(String stSex) {
		this.stSex = stSex;
	}
	public Integer getStGrade() {
		return stGrade;
	}
	public void setStGrade(Integer stGrade) {
		this.stGrade = stGrade;
	}
	public Timestamp getStBirth() {
		return stBirth;
	}
	public void setStBirth(Timestamp stBirth) {
		this.stBirth = stBirth;
	}
	public Integer getStAge() {
		return stAge;
	}
	public void setStAge(Integer stAge) {
		this.stAge = stAge;
	}
	public Long getStPhone1() {
		return stPhone1;
	}
	public void setStPhone1(Long stPhone1) {
		this.stPhone1 = stPhone1;
	}
	public Long getStPhone2() {
		return stPhone2;
	}
	public void setStPhone2(Long stPhone2) {
		this.stPhone2 = stPhone2;
	}
	public Long getStIds() {
		return stIds;
	}
	public void setStIds(Long stIds) {
		this.stIds = stIds;
	}
	public String getStDepartment() {
		return stDepartment;
	}
	public void setStDepartment(String stDepartment) {
		this.stDepartment = stDepartment;
	}
	public Integer getSaId() {
		return saId;
	}
	public void setSaId(Integer saId) {
		this.saId = saId;
	}
	public String getStPassword() {
		return stPassword;
	}
	public void setStPassword(String stPassword) {
		this.stPassword = stPassword;
	}
	public Timestamp getStCreatTime() {
		return stCreatTime;
	}
	public void setStCreatTime(Timestamp stCreatTime) {
		this.stCreatTime = stCreatTime;
	}
	public Timestamp getStUpdateTime() {
		return stUpdateTime;
	}
	public void setStUpdateTime(Timestamp stUpdateTime) {
		this.stUpdateTime = stUpdateTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff(String stName, Long stOrdernum, String stSex, Integer stGrade,
			Timestamp stBirth, Integer stAge, Long stPhone1, Long stPhone2,
			Long stIds, String stDepartment, String stPassword,
			Timestamp stCreatTime, Timestamp stUpdateTime) {
		super();
		this.stName = stName;
		this.stOrdernum = stOrdernum;
		this.stSex = stSex;
		this.stGrade = stGrade;
		this.stBirth = stBirth;
		this.stAge = stAge;
		this.stPhone1 = stPhone1;
		this.stPhone2 = stPhone2;
		this.stIds = stIds;
		this.stDepartment = stDepartment;
		this.stPassword = stPassword;
		this.stCreatTime = stCreatTime;
		this.stUpdateTime = stUpdateTime;
	}
	public Staff(Integer stId, String stName, Long stOrdernum, String stSex,
			Integer stGrade, Timestamp stBirth, Integer stAge, Long stPhone1,
			Long stPhone2, Long stIds, String stDepartment, String stPassword,
			Timestamp stCreatTime, Timestamp stUpdateTime) {
		super();
		this.stId = stId;
		this.stName = stName;
		this.stOrdernum = stOrdernum;
		this.stSex = stSex;
		this.stGrade = stGrade;
		this.stBirth = stBirth;
		this.stAge = stAge;
		this.stPhone1 = stPhone1;
		this.stPhone2 = stPhone2;
		this.stIds = stIds;
		this.stDepartment = stDepartment;
		this.stPassword = stPassword;
		this.stCreatTime = stCreatTime;
		this.stUpdateTime = stUpdateTime;
	}
    
    

    




}