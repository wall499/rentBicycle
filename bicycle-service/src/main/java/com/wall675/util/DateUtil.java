package com.wall675.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	/**
	 * 获取系统当前时间  yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String currentTime() {
		LocalDateTime now = LocalDateTime.now();
		return now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	
	/**
	 * 获取系统当前月份  yyyy-MM
	 * @return
	 */
	public static String curMonth() {
		LocalDateTime now = LocalDateTime.now();
		return now.format(DateTimeFormatter.ofPattern("yyyy-MM"));
	} 
	
	/**
	 * 获取系统当前日期
	 * @return
	 */
	public static String currentDate() {
		return LocalDate.now().toString();
	} 
	
	public static void main(String[] args) {
		System.out.println(currentDate());
	}

}
