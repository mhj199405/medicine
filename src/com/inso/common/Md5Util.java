package com.inso.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
       /** 传一个密码进来  返回 md5处理后的密码  */
	   public   static  String   md5Str(String   password){
		      try {
				MessageDigest   md  =  MessageDigest.getInstance("MD5");
				md.update(password.getBytes());
				byte[]  md5Bytes = md.digest();
				System.out.println(md5Bytes.length);
				// 谁能把byte数组 变成 32位的16进制形式   只要把每个byte 变成2位16进制
				// 1byte = 8bit   只要使用4bit变成一个16进制位
				StringBuffer   strBuf = new StringBuffer();
				for(int  i=0;i<md5Bytes.length;i++){
					   byte  b = md5Bytes[i];
					   // 把b 变成 16 进制 
					  String  hx = Integer.toHexString(b&0xff);
					  if(hx.length() < 2){
						     hx = "0" + hx;
					  }
					  strBuf.append(hx);
				}
				return  strBuf.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		    return  password;
	   }

	public static void main(String[] args) {
		String md5Str = md5Str("123456");
		System.out.println("加密之后的密码："+md5Str);
	}
}
