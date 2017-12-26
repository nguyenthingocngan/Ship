package com.ship.domain;

public class Ward {
	private String wardId;
	private String name;
	private District dis;
	
	public Ward(){
		
	}
	
	public Ward(String wardId, String name, District dis) {
		super();
		this.wardId = wardId;
		this.name = name;
	}

	public String getWardId() {
		return wardId;
	}

	public void setWardId(String wardId) {
		this.wardId = wardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public District getDis() {
		return dis;
	}

	public void setDis(District dis) {
		this.dis = dis;
	}

}
