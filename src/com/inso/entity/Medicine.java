package com.inso.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Medicine implements Serializable{
 
	
	private static final long serialVersionUID = 1L;

	
    private Integer mId;
    private String medName;
    private Long price;
    private Integer medNum;
    private Timestamp prouductDate;
    private Timestamp saveDate;
    private String producter;
    private String prouductArea;
    private Long phone;
    private Timestamp careatTime;
    private Timestamp updateTime;
    
    
    
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public Integer getmId() {
		return mId;
	}
	public void setmId(Integer mId) {
		this.mId = mId;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Integer getMedNum() {
		return medNum;
	}
	public void setMedNum(Integer medNum) {
		this.medNum = medNum;
	}
	public Timestamp getProuductDate() {
		return prouductDate;
	}
	public void setProuductDate(Timestamp prouductDate) {
		this.prouductDate = prouductDate;
	}
	public Timestamp getSaveDate() {
		return saveDate;
	}
	public void setSaveDate(Timestamp saveDate) {
		this.saveDate = saveDate;
	}
	public String getProducter() {
		return producter;
	}
	public void setProducter(String producter) {
		this.producter = producter;
	}
	public String getProuductArea() {
		return prouductArea;
	}
	public void setProuductArea(String prouductArea) {
		this.prouductArea = prouductArea;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Timestamp getCareatTime() {
		return careatTime;
	}
	public void setCareatTime(Timestamp careatTime) {
		this.careatTime = careatTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medicine(Integer mId, String medName, Long price, Integer medNum,
			Timestamp prouductDate, Timestamp saveDate, String producter,
			String prouductArea, Long phone, Timestamp careatTime,
			Timestamp updateTime) {
		super();
		this.mId = mId;
		this.medName = medName;
		this.price = price;
		this.medNum = medNum;
		this.prouductDate = prouductDate;
		this.saveDate = saveDate;
		this.producter = producter;
		this.prouductArea = prouductArea;
		this.phone = phone;
		this.careatTime = careatTime;
		this.updateTime = updateTime;
	}
	public Medicine(String medName, Long price, Integer medNum,
			Timestamp prouductDate, Timestamp saveDate, String producter,
			String prouductArea, Long phone, Timestamp careatTime,
			Timestamp updateTime) {
		super();
		this.medName = medName;
		this.price = price;
		this.medNum = medNum;
		this.prouductDate = prouductDate;
		this.saveDate = saveDate;
		this.producter = producter;
		this.prouductArea = prouductArea;
		this.phone = phone;
		this.careatTime = careatTime;
		this.updateTime = updateTime;
	}

	
	
    
    



    
}