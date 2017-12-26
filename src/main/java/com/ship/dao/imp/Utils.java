package com.ship.dao.imp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.text.DateFormatter;

public class Utils {
	public static String dateFormat(Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String reportDate = df.format(date);
		return reportDate;
	}
	
	public static Date afterOneDayDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return calendar.getTime();
	}

/*	public static Date dateFormatDate(Date date){
		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		cal.setTimeInMillis(date);
		return cal.getTime();
	}*/
	
	public static void main(String[] args) {   
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	System.out.println("Date : " + sdf.format(calendar.getTime()));

	//add one month
	calendar.add(Calendar.MONTH, 1);
	System.out.println("Date : " + sdf.format(calendar.getTime()));

	//subtract 10 days
	calendar.add(Calendar.DAY_OF_MONTH, -1);
	System.out.println("Date : " + sdf.format(calendar.getTime()));
	}

}
