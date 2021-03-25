package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Profile")
public class Profile {

	@Id
	private String userId;
	private String address="";
	private String district="";
	private String city="";

	
	public Profile() {
		super();
	}

	public Profile(String address, String district, String city, String userId) {
		super();
		this.address = address;
		this.district = district;
		this.city = city;
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUserId() {
		return userId;
	}


}
