package com.ship.dao;

import com.ship.domain.User;


public interface UserDAO {

	 void insert(User user);
	//public Order findByCustomerId(int custId);
/*	DataSource getDataSource();*/
	
	 User getUserbyName(String user);
	 
	 User getUserbyName(User user);

}
