package com.ship.domain;

public class OrderStatus {
	private String orderStatusId;
	private String status;
	
	public OrderStatus(){
		
	}
	public OrderStatus(String orderStatusId, String status) {
		super();
		this.orderStatusId = orderStatusId;
		this.status = status;
	}

	public String getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(String orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
	

}
