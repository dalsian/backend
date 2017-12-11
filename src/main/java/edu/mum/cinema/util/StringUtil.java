package edu.mum.cinema.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class StringUtil {
	
	public static String generateOrderNumber() {
		
		Calendar calendar = Calendar.getInstance();
		StringBuffer buffer = new StringBuffer("O-");
		buffer.append(calendar.get(Calendar.YEAR));
		buffer.append(calendar.get(Calendar.MONTH));
		buffer.append(calendar.get(Calendar.DAY_OF_MONTH));
		buffer.append("-");
		buffer.append(calendar.getTimeInMillis());
		
		return buffer.toString();
	}
	
	public static String generateTicketNumber() {
		
		Calendar calendar = Calendar.getInstance();
		StringBuffer buffer = new StringBuffer("T-");
		buffer.append(calendar.get(Calendar.YEAR));
		buffer.append(calendar.get(Calendar.MONTH));
		buffer.append(calendar.get(Calendar.DAY_OF_MONTH));
		buffer.append("-");
		buffer.append(calendar.getTimeInMillis());
		
		return buffer.toString();
	}
	
	public static String hash(String plain) {
		
		byte[] bytesOfMessage;
		MessageDigest md;
		byte[] thedigest = null;
		
		try {
			bytesOfMessage = plain.getBytes("UTF-8");
			md = MessageDigest.getInstance("MD5");
			thedigest = md.digest(bytesOfMessage);
			
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return thedigest.toString();
	}
	
	public static Map<String, String> paramsToMap(String params) {
		Map<String,String> paramMap = new HashMap<>();
		
		for(String param : params.split("&")) {
			String[] keyval = param.split("=");
			paramMap.put(keyval[0], keyval[1]);
		}
		return paramMap;
	}
	
	public static void main(String[] args) {
		System.out.println(generateOrderNumber());
		System.out.println(generateTicketNumber());
		System.out.println(hash("Hello"));
		System.out.println(hash("Hellp"));
		System.out.println(hash("Dalsian"));
	}
}
