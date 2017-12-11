package edu.mum.cinema.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	private static SimpleDateFormat fullDate = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss");

	public static String getDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(calendar.get(Calendar.MONTH));
		buffer.append("/");
		buffer.append(calendar.get(Calendar.DAY_OF_MONTH));
		buffer.append("/");
		buffer.append(calendar.get(Calendar.YEAR));
		
		return buffer.toString();
	}
	
	public static String getTime(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(date);
	}
	
	public static Date toDate(String fulldate) {
		Date date = null;
		try {
			date = fullDate.parse(fulldate); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
	}
}
