package com.ship.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;
import javax.swing.text.DateFormatter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ship.domain.OrderStatus;

public class Utils {
	
	public static ApplicationContext context =
    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	private static DataSource dataSource = (DataSource) context.getBean("dataSource");
	public static final Map<String, OrderStatus> ORDER_STATUS_MAP = getOrderStatus();
	
	public static Map<String, OrderStatus> getOrderStatus() {
		String SELECT_ORDER_STATUS = "SELECT * FROM `ORDER_STATUS`;";
		Map<String, OrderStatus> map = new HashMap<>();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_ORDER_STATUS);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				map.put(rs.getString("ID_ORDER_STATUS"), new OrderStatus(rs.getString("ID_ORDER_STATUS"), rs.getString("STATUS")));
			}
			rs.close();
			return map;
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}

		}
		return null;
	}
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
