package com.rpm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatting {
	Date d=new Date();
	public String ymdhms() {
		
		SimpleDateFormat sdate = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		String date=sdate.format(d);
		return date;	
	}
	public String ymd() {
		SimpleDateFormat sdate = new SimpleDateFormat("YYYY-MM-dd");
		String date=sdate.format(d);
		return date;	
	}
	
	public String hh() {
		SimpleDateFormat df = new SimpleDateFormat("HH");
		String str=df.format(d);
		int a=Integer.parseInt(str);
		if (a>=5&&a<8) {
			
			return "早上";		
		}
		if (a>=8&&a<12) {
			
			return "上午";		
		}
		if (a>12&&a<14) {
			
			return "中午";	
		}
		if (a>=14&&a<18) {
			
			return "下午";	
		}
		
		return "晚上";
	}
}
