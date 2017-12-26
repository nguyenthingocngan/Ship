package com.ship.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.ship.domain.City;
import com.ship.domain.District;
import com.ship.domain.Order;
import com.ship.domain.OrderStatus;
import com.ship.domain.Role;
import com.ship.domain.User;
import com.ship.domain.Ward;
import com.ship.dao.OrderDAO;

public class OrderImpl implements OrderDAO {
	//public static final Map<String, OrderStatus> ORDER_STATUS_MAP = getOrderStatus();

	String insert_order = "INSERT INTO `ORDER` "
			+ "(INDEX, ID_ORDER, CUSTOMER_NAME, ADDRESS, FEE_SHIP, FEE_PRODUCT, FEE_TOTAL, NOTE, DATE , ID_USER, ID_STATUS_ORDER, ID_DISTRICT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? , ?, ?, ? );";
	String SELECT_ORDER = "select * from `order` where 	`date` between " + "'@@'" + " and " + "'@@@'" + " order by date desc;";

	private static DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		System.out.println(dataSource);
		return dataSource;
	}

	public void insert(Order order) {

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(insert_order);
			ps.setInt(1, order.getIndex());
			ps.setString(2, order.getIdOrder());
			ps.setString(3, order.getCustomerName());
			ps.setString(4, order.getAddress());
			ps.setDouble(5, order.getShipFee());
			ps.setDouble(6, order.getProductFee());
			ps.setDouble(7, order.getTotalFee());
			ps.setString(8, order.getNote());
			ps.setString(9, Utils.dateFormat(order.getDate()));
			ps.setString(10, "");
			ps.setString(11, "");
			ps.setString(12, "");
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public List<Order> getOrder(Date fromDate, Date toDate) {
		
		List<Order> list = new ArrayList();
		Connection conn = null;
		if (toDate == null){
			toDate = new Date();
			fromDate = Utils.afterOneDayDate(toDate);
		} 
		SELECT_ORDER = SELECT_ORDER.replace("@@@", Utils.dateFormat(toDate));
		SELECT_ORDER = SELECT_ORDER.replace("@@", Utils.dateFormat(fromDate));


		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_ORDER);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				int index = result.getInt("INDEX");
				String orderId = result.getString("ID_ORDER");
				String customerName = result.getString("CUSTOMER_NAME");
				String address = result.getString("ADDRESS");
				Double totalFee = result.getDouble("FEE_TOTAL");
				Double shipFee = result.getDouble("FEE_SHIP");
				Double productFee = result.getDouble("FEE_PRODUCT");
				String note = result.getString("NOTE");
				Date date = result.getDate("DATE");
				String userId = result.getString("ID_USER");
				String statusId = result.getString("ID_STATUS_ORDER");
				String addressId = result.getString("ID_DISTRICT");
				list.add(new Order(index, orderId, customerName, address, totalFee, shipFee, productFee, note, date,
						new User(), new OrderStatus(), new City(), new District(), new Ward()));
			}
			ps.close();
			return list;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

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
	

	/*
	 * public City getFullAddress(String disstrictId){ String SELECT_CTIY = ``
	 * 
	 * }
	 */

}
