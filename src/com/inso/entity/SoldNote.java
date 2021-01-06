package com.inso.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class SoldNote implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer soldId;
    private String solderName;
    private Timestamp soldTime;
    private Long orderId;
    private String customerName;
	
    
    public Integer getSoldId() {
		return soldId;
	}
	public void setSoldId(Integer soldId) {
		this.soldId = soldId;
	}
	public String getSolderName() {
		return solderName;
	}
	public void setSolderName(String solderName) {
		this.solderName = solderName;
	}
	public Timestamp getSoldTime() {
		return soldTime;
	}
	public void setSoldTime(Timestamp soldTime) {
		this.soldTime = soldTime;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public SoldNote() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SoldNote(Integer soldId, String solderName, Timestamp soldTime,
			Long orderId, String customerName) {
		super();
		this.soldId = soldId;
		this.solderName = solderName;
		this.soldTime = soldTime;
		this.orderId = orderId;
		this.customerName = customerName;
	}
	public SoldNote(String solderName, Timestamp soldTime, Long orderId,
			String customerName) {
		super();
		this.solderName = solderName;
		this.soldTime = soldTime;
		this.orderId = orderId;
		this.customerName = customerName;
	}

    
}