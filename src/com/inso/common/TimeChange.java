package com.inso.common;

import java.sql.Timestamp;

/**
 * 时间转换工具
 *
 * Create By MH·J on 2019/3/10
 *
 */
public class TimeChange {

	public Timestamp dateChange(String time){

	    //获取当前系统的毫秒值并转换为Timestamp
		Timestamp ts = new Timestamp(System.currentTimeMillis());   
        try {   
            ts = Timestamp.valueOf(time);   
 
        } catch (Exception e) {   
            e.printStackTrace();   
        } 
        return ts;
	}
}
