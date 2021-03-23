package com.example.demo.model;

public class ShippingAddress {
	private String address;
	private String district;
	private String city;
	public ShippingAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShippingAddress(String address, String district, String city) {
		super();
		this.address = address;
		this.district = district;
		this.city = city;
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
}
