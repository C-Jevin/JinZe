package com.jinze.util;

import java.util.regex.Pattern;


/**
 * 校验器：利用正则表达式校验邮箱、手机号等
 * 
 * @author hakim2016
 * 
 */
public class Validator {

	/**
	 * 正则表达式：验证用户名 以字母开头，长度在5-16之间，只能包含字符，数字，下划线
	 */
	public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{4,15}$";

	/**
	 * 正则表达式：验证密码 最小6位，最大16位，以中英文数字组成
	 */
	public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";

	/**
	 * 正则表达式：验证非空 正整数
	 */
	public static final String REGEX_POSITIVE_NUM = "^[0-9]*[1-9][0-9]*$";
	/**
	 * 非负浮点数 验证 价格
	 */
	public static final String REGEX_POSITIVE_DOUBLE = "^\\d+(\\.\\d+)?$";
	/**
	 * 
	 */
	public static final String REGEX_DATE = "^\\d{4}-\\d{1,2}-\\d{1,2}";
	/**
	 * 身份证
	 */
	public static final String PERSON_CARD= "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
	/**
	 * 中文字符
	 */ 
	public static final String CHINESE_NAME = "^([\u4e00-\u9fa5]){2,8}$";
	/**
	 * 校验非空正整数
	 * 
	 * @param 正整数
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isPositiveNum(String number) {
		return Pattern.matches(REGEX_POSITIVE_NUM, number);
	}

	public static boolean isChineseName(String name){
		return Pattern.matches(CHINESE_NAME, name);
	}
	public static boolean isPersonCard(String number) {
		return Pattern.matches(PERSON_CARD, number);
	}
	/**
	 * 验证非负浮点数
	 * 
	 * @param price
	 * @return
	 */
	public static boolean isPostiveDouble(String price) {
		return Pattern.matches(REGEX_POSITIVE_DOUBLE,price);
	}

	/**
	 * 校验用户名
	 * 
	 * @param username
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isUsername(String username) {
		return Pattern.matches(REGEX_USERNAME, username);
	}

	/**
	 * 校验密码
	 * 
	 * @param password
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isPassword(String password) {
		return Pattern.matches(REGEX_PASSWORD, password);
	}

	/**
	 * 校验日期
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isDate(String date) {
		return Pattern.matches(REGEX_DATE, date);
	}
	
	public static boolean isDouble(Double price) {
		if(price <=0){
			return true;
	}
			else{
			return false;
		}	
	}
	public static boolean isInt(int count) {
		if(count <=0){
			return true;
		}else{
			return false;
		}
	}
}
