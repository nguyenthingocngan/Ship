package com.ship.domain;

public class District {
	private String disId;
	private String name;
	private Ward ward;
	
	public District(){
		
	}
	public District(String disId, String name, Ward ward) {
		super();
		this.disId = disId;
		this.name = name;
		this.ward = ward;
	}

	public String getDisId() {
		return disId;
	}

	public void setDisId(String disId) {
		this.disId = disId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}


}
