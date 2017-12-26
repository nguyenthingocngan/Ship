package com.ship.domain;

import java.util.Date;

public class Order {

private int index;
private String idOrder;
private String customerName;
private String address;
private Double totalFee;
private Double shipFee;
private Double productFee;
private String note;
private Date date;
private User user;
private OrderStatus orderStatus;
private City city;
private District distr;
private Ward ward;


public Order(int index, String idOrder, String customerName, String address, Double totalFee, Double shipFee,
		Double productFee, String note, Date date, User user, OrderStatus orderStatus, City city, District distr,
		Ward ward) {
	super();
	this.index = index;
	this.idOrder = idOrder;
	this.customerName = customerName;
	this.address = address;
	this.totalFee = totalFee;
	this.shipFee = shipFee;
	this.productFee = productFee;
	this.note = note;
	this.date = date;
	this.user = user;
	this.orderStatus = orderStatus;
	this.city = city;
	this.distr = distr;
	this.ward = ward;
}
public int getIndex() {
	return index;
}
public void setIndex(int index) {
	this.index = index;
}
public String getIdOrder() {
	return idOrder;
}
public void setIdOrder(String idOrder) {
	this.idOrder = idOrder;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Double getTotalFee() {
	return totalFee;
}
public void setTotalFee(Double totalFee) {
	this.totalFee = totalFee;
}
public Double getShipFee() {
	return shipFee;
}
public void setShipFee(Double shipFee) {
	this.shipFee = shipFee;
}
public Double getProductFee() {
	return productFee;
}
public void setProductFee(Double productFee) {
	this.productFee = productFee;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public OrderStatus getOrderStatus() {
	return orderStatus;
}
public void setOrderStatus(OrderStatus orderStatus) {
	this.orderStatus = orderStatus;
}
public City getCity() {
	return city;
}
public void setCity(City city) {
	this.city = city;
}
public District getDistr() {
	return distr;
}
public void setDistr(District distr) {
	this.distr = distr;
}
public Ward getWard() {
	return ward;
}
public void setWard(Ward ward) {
	this.ward = ward;
}
	
	
}
