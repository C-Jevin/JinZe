package com.jinze.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * 日期转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getStrFromDate(Date date,String format){
		SimpleDateFormat df = new SimpleDateFormat(format);
		String str = df.format(date);
		return str;
	}
	/**
	 * 字符串--->日期
	 * @param str
	 * @param format
	 * @return
	 */
	public static Date getDateFromStr(String str,String format){
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = df.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
