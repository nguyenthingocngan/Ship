package com.ship.domain;

public class User {
	
	private String userId;
	private String userName;
	private String passWord;
	private String email;
	private String phone;
	private Role role;
	private String address;
	private Ward ward;
	private City city;
	public User(){
		
	}
	public User(String userId, String userName, String passWord, String email, String phone, Role role, String address, Ward ward, City city) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.address = address;
		this.ward = ward;
		this.city = city;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Ward getWard() {
		return ward;
	}
	public void setWard(Ward ward) {
		this.ward = ward;
	}
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public boolean equal(User user){
		return this.getUserName().equals(user.userName) && this.getPassWord().equals(user.getPassWord());
	}
}
