package com.inso.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Member implements Serializable {
 

	private static final long serialVersionUID = 1L;
	
	
	private Integer memberId;
    private Integer memberGarde;
    private String memberLipin;
    private Timestamp memberLasttime;
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getMemberGarde() {
		return memberGarde;
	}
	public void setMemberGarde(Integer memberGarde) {
		this.memberGarde = memberGarde;
	}
	public String getMemberLipin() {
		return memberLipin;
	}
	public void setMemberLipin(String memberLipin) {
		this.memberLipin = memberLipin;
	}
	public Timestamp getMemberLasttime() {
		return memberLasttime;
	}
	public void setMemberLasttime(Timestamp memberLasttime) {
		this.memberLasttime = memberLasttime;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(Integer memberId, Integer memberGarde, String memberLipin,
			Timestamp memberLasttime) {
		super();
		this.memberId = memberId;
		this.memberGarde = memberGarde;
		this.memberLipin = memberLipin;
		this.memberLasttime = memberLasttime;
	}
	public Member(Integer memberGarde, String memberLipin,
			Timestamp memberLasttime) {
		super();
		this.memberGarde = memberGarde;
		this.memberLipin = memberLipin;
		this.memberLasttime = memberLasttime;
	}

   
    
}