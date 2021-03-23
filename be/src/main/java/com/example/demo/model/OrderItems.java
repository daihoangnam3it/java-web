package com.example.demo.model;

public class OrderItems {
	private String name;
	private int qty;
	private String image;
	private float price;
	private String product;
	public OrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItems(String name, int qty, String image, float price, String product) {
		super();
		this.name = name;
		this.qty = qty;
		this.image = image;
		this.price = price;
		this.product = product;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
}
