package com.ship.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.ship.dao.UserDAO;
import com.ship.domain.City;
import com.ship.domain.Role;
import com.ship.domain.Role.USER_ROLE;
import com.ship.domain.User;
import com.ship.domain.Ward;
 
/**
 * @author Ngan Nguyen
 *
 */
public class UserImpl implements UserDAO {
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public DataSource getDataSource() {
		System.out.println(dataSource);
		return dataSource;
	}
	public void insert(User user){

/*		String sql = "INSERT INTO `ORDER` " +		
		"(CUSTOMER_NAME, ADDRESS, FEE_SHIP, FEE_PRODUCT, FEE_TOTAL, NOTE ) "
		+ "VALUES (?, ?, ?, ?, ?, ?);";
		*/
		String INSERT_USER = "INSERT INTO `USER` " +
		"(ID_USER, USER_NAME, PASS_WORD, EMAIL, PHONE, ID_WARD, ID_ROLE, ADDRESS)" +
		"VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
				
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT_USER);
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getPassWord());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getWard().getWardId());
			ps.setString(7, user.getRole().getRoleId());
			ps.setString(9, user.getAddress());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	public User getUserbyName(String userName) {

		String sql = "SELECT * FROM `USER` WHERE `user_name` = '" + userName + "'";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
				
			if(rs.next()){
				return getUser(rs);
			}
			ps.close();
			rs.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return null;
	}
	
	public User getUser(ResultSet rs){
		String userId;
		try {
			userId = rs.getString("ID_USER");
			String userName = rs.getString("USER_NAME");
			Role role = getRolebyIdRole(rs.getString("ID_ROLE"));
			City city = getCitybyWardId(userId);
			Ward ward = null;
			if(city != null && city.getDistrict() != null){
				ward = city.getDistrict().getWard();
			}
			User user = new User(userId, userName, rs.getString("PASS_WORD"), rs.getString("EMAIL"), rs.getString("PHONE"), role, rs.getString("ADDRESS"), ward ,city);
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public City getCitybyWardId(String wardId){
		if(wardId != null){
			
		}
		return new City();
		
	}
	
	public Role getRolebyIdRole(String roleId){
		String SELECT_ROLE = "SELECT * FROM `ROLE` WHERE `ID_ROLE` = '" + roleId + "'";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_ROLE);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return new Role(rs.getString("ID_ROLE"), Role.getRole(rs.getString("ROLE_NAME"))); 
			}
			rs.close();
		} catch (SQLException e) {
	
			e.printStackTrace();		
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
			
		}
		return null;
	}
	
	public User getUserbyName(User user) {
		if(user!= null && user.getUserName() != null){
			return getUserbyName(user.getUserName());
		}
		return null;
	}


}
