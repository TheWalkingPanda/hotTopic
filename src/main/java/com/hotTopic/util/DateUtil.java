package com.hotTopic.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String date2String(Date date, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static Date string2Date(String dateStr, String pattern) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(dateStr);
	}
}
