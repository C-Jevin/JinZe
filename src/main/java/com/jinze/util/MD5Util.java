package com.jinze.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Util {
	public static String md5(String password){
		String newStr =null;
		try {
			//1.获取到md5加密对象
			MessageDigest md = MessageDigest.getInstance("MD5");
			//对传过来的字符串进行加密
			byte[] digest = md.digest(password.getBytes());
			
			//将md5加密后的字节数组再次加密，base64加密
			BASE64Encoder encoder = new BASE64Encoder();
			
			newStr = encoder.encode(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
		return newStr;
	}
	public static void main(String[] args) {
		String a="范嘉恒";
		String b="1";
		System.out.println(MD5Util.md5(a));
		System.out.println(MD5Util.md5(b));
	}
	
}
