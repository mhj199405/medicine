package com.inso.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemTimeTypeTimestamp {

	
	public Timestamp getSystemTimeTypeTimestap(){

		
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		Timestamp timestamp = new TimeChange().dateChange(dateString);
		
		return timestamp;
	}
	
	
}
