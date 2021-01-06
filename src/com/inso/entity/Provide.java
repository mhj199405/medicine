package com.inso.entity;

import java.io.Serializable;

public class Provide implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer proId;
    private String proName;
    private Long proNum;
    private String medType;
    private String orders;
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Long getProNum() {
		return proNum;
	}
	public void setProNum(Long proNum) {
		this.proNum = proNum;
	}
	public String getMedType() {
		return medType;
	}
	public void setMedType(String medType) {
		this.medType = medType;
	}
	public String getOrders() {
		return orders;
	}
	public void setOrders(String orders) {
		this.orders = orders;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Provide() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Provide(Integer proId, String proName, Long proNum, String medType,
			String orders) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.proNum = proNum;
		this.medType = medType;
		this.orders = orders;
	}
	public Provide(String proName, Long proNum, String medType, String orders) {
		super();
		this.proName = proName;
		this.proNum = proNum;
		this.medType = medType;
		this.orders = orders;
	}


    
   
}