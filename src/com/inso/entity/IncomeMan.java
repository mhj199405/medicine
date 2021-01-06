package com.inso.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class IncomeMan implements Serializable{
 

	private static final long serialVersionUID = 1L;
	
	
	private Integer inId;
    private String inName;
    private Integer inNumber;
    private Integer inOrdernum;
    private String inPay;
    private Integer inCard;
    private String inCashier;
    private Timestamp inCreateTime;
    
    
    
	public String getInCashier() {
		return inCashier;
	}
	public void setInCashier(String inCashier) {
		this.inCashier = inCashier;
	}
	public Timestamp getInCreateTime() {
		return inCreateTime;
	}
	public void setInCreateTime(Timestamp inCreateTime) {
		this.inCreateTime = inCreateTime;
	}
	public Integer getInId() {
		return inId;
	}
	public void setInId(Integer inId) {
		this.inId = inId;
	}
	public String getInName() {
		return inName;
	}
	public void setInName(String inName) {
		this.inName = inName;
	}
	public Integer getInNumber() {
		return inNumber;
	}
	public void setInNumber(Integer inNumber) {
		this.inNumber = inNumber;
	}
	public Integer getInOrdernum() {
		return inOrdernum;
	}
	public void setInOrdernum(Integer inOrdernum) {
		this.inOrdernum = inOrdernum;
	}
	public String getInPay() {
		return inPay;
	}
	public void setInPay(String inPay) {
		this.inPay = inPay;
	}
	public Integer getInCard() {
		return inCard;
	}
	public void setInCard(Integer inCard) {
		this.inCard = inCard;
	}
	public IncomeMan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IncomeMan(Integer inId, String inName, Integer inNumber,
			Integer inOrdernum, String inPay, Integer inCard, String inCashier,
			Timestamp inCreateTime) {
		super();
		this.inId = inId;
		this.inName = inName;
		this.inNumber = inNumber;
		this.inOrdernum = inOrdernum;
		this.inPay = inPay;
		this.inCard = inCard;
		this.inCashier = inCashier;
		this.inCreateTime = inCreateTime;
	}
	public IncomeMan(String inName, Integer inNumber, Integer inOrdernum,
			String inPay, Integer inCard, String inCashier,
			Timestamp inCreateTime) {
		super();
		this.inName = inName;
		this.inNumber = inNumber;
		this.inOrdernum = inOrdernum;
		this.inPay = inPay;
		this.inCard = inCard;
		this.inCashier = inCashier;
		this.inCreateTime = inCreateTime;
	}


	

  
    
}