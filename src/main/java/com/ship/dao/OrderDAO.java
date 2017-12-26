package com.ship.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.ship.domain.Order;

public interface OrderDAO {

	void insert(Order customer);
	//public Order findByCustomerId(int custId);
/*	DataSource getDataSource();*/
	List<Order> getOrder(Date date1, Date date2);
	

}
