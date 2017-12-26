package com.ship.domain;

public class City {
	private String cityId;
	private String name;
	private District district;
	
	public City(){
		
	}
	public City(String cityId, String name) {
		super();
		this.cityId = cityId;
		this.name = name;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}

	
}
