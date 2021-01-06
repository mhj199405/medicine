package com.inso.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class IntoMan implements Serializable{
  

	private static final long serialVersionUID = 1L;

	private Integer intoId;
    private String intoName;
    private String intoType;
    private Integer intoNumber;  
    private Long intoPrice;
    private Timestamp intoCreateTime;
    
    
    
    
	public Long getIntoPrice() {
		return intoPrice;
	}
	public void setIntoPrice(Long intoPrice) {
		this.intoPrice = intoPrice;
	}
	public Timestamp getIntoCreateTime() {
		return intoCreateTime;
	}
	public void setIntoCreateTime(Timestamp intoCreateTime) {
		this.intoCreateTime = intoCreateTime;
	}
	public Integer getIntoId() {
		return intoId;
	}
	public void setIntoId(Integer intoId) {
		this.intoId = intoId;
	}
	public String getIntoName() {
		return intoName;
	}
	public void setIntoName(String intoName) {
		this.intoName = intoName;
	}
	public String getIntoType() {
		return intoType;
	}
	public void setIntoType(String intoType) {
		this.intoType = intoType;
	}
	public Integer getIntoNumber() {
		return intoNumber;
	}
	public void setIntoNumber(Integer intoNumber) {
		this.intoNumber = intoNumber;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public IntoMan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IntoMan(Integer intoId, String intoName, String intoType,
			Integer intoNumber, Long intoPrice, Timestamp intoCreateTime) {
		super();
		this.intoId = intoId;
		this.intoName = intoName;
		this.intoType = intoType;
		this.intoNumber = intoNumber;
		this.intoPrice = intoPrice;
		this.intoCreateTime = intoCreateTime;
	}
	public IntoMan(String intoName, String intoType, Integer intoNumber,
			Long intoPrice, Timestamp intoCreateTime) {
		super();
		this.intoName = intoName;
		this.intoType = intoType;
		this.intoNumber = intoNumber;
		this.intoPrice = intoPrice;
		this.intoCreateTime = intoCreateTime;
	}

	

   
    
}