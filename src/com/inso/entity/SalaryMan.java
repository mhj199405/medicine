package com.inso.entity;

import java.io.Serializable;

public class SalaryMan implements Serializable{

 
	private static final long serialVersionUID = 1L;
	
	
	private Integer saId;
    private Long saNumber;
    private String saOvertime;
    private String saChidao;
    private String saZaotui;
    private Long saLastsalary;
    private Integer stId;
    private Staff staff;
    
	public Integer getSaId() {
		return saId;
	}
	public void setSaId(Integer saId) {
		this.saId = saId;
	}
	public Long getSaNumber() {
		return saNumber;
	}
	public void setSaNumber(Long saNumber) {
		this.saNumber = saNumber;
	}
	public String getSaOvertime() {
		return saOvertime;
	}
	public void setSaOvertime(String saOvertime) {
		this.saOvertime = saOvertime;
	}
	public String getSaChidao() {
		return saChidao;
	}
	public void setSaChidao(String saChidao) {
		this.saChidao = saChidao;
	}
	public String getSaZaotui() {
		return saZaotui;
	}
	public void setSaZaotui(String saZaotui) {
		this.saZaotui = saZaotui;
	}
	public Long getSaLastsalary() {
		return saLastsalary;
	}
	public void setSaLastsalary(Long saLastsalary) {
		this.saLastsalary = saLastsalary;
	}
	public Integer getStId() {
		return stId;
	}
	public void setStId(Integer stId) {
		this.stId = stId;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}

   
}