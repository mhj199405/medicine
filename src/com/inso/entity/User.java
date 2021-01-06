package com.inso.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer userId;
    private String userName;
    private Integer memberDengji;
    private Timestamp birth;
    private Long userPhone;
    private String userAddress;
    private Long balance;
    private Integer point;
    private String records;
    private Integer state;
    private Timestamp recharge;
    private Long userMoney;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getMemberDengji() {
		return memberDengji;
	}
	public void setMemberDengji(Integer memberDengji) {
		this.memberDengji = memberDengji;
	}
	public Timestamp getBirth() {
		return birth;
	}
	public void setBirth(Timestamp birth) {
		this.birth = birth;
	}
	public Long getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(Long userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public String getRecords() {
		return records;
	}
	public void setRecords(String records) {
		this.records = records;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Timestamp getRecharge() {
		return recharge;
	}
	public void setRecharge(Timestamp recharge) {
		this.recharge = recharge;
	}
	public Long getUserMoney() {
		return userMoney;
	}
	public void setUserMoney(Long userMoney) {
		this.userMoney = userMoney;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer userId, String userName, Integer memberDengji,
			Timestamp birth, Long userPhone, String userAddress,
			Long balance, Integer point, String records, Integer state,
			Timestamp recharge, Long userMoney) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.memberDengji = memberDengji;
		this.birth = birth;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.balance = balance;
		this.point = point;
		this.records = records;
		this.state = state;
		this.recharge = recharge;
		this.userMoney = userMoney;
	}
	public User(String userName, Integer memberDengji, Timestamp birth,
			Long userPhone, String userAddress, Long balance, Integer point,
			String records, Integer state, Timestamp recharge, Long userMoney) {
		super();
		this.userName = userName;
		this.memberDengji = memberDengji;
		this.birth = birth;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.balance = balance;
		this.point = point;
		this.records = records;
		this.state = state;
		this.recharge = recharge;
		this.userMoney = userMoney;
	}
   
    
    
    
}