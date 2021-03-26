package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Product {
	@Id
	private String id;
	private String name;
	private String image;
	private String description;
	private String brand;
	private String category;
	private float price;
	private int countInStock;
	private float rating;
	private int numReviews;
	
	public Product() {
		super();
	}

	public Product(String name, String image, String description, String brand, String category, float price,
			int countInStock, float rating, int numReviews) {
		super();
		this.name = name;
		this.image = image;
		this.description = description;
		this.brand = brand;
		this.category = category;
		this.price = price;
		this.countInStock = countInStock;
		this.rating = rating;
		this.numReviews = numReviews;
	}
	
	public Product(String id, String name, String image, String description, String brand, String category, float price,
			int countInStock, float rating, int numReviews) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.description = description;
		this.brand = brand;
		this.category = category;
		this.price = price;
		this.countInStock = countInStock;
		this.rating = rating;
		this.numReviews = numReviews;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getCountInStock() {
		return countInStock;
	}

	public void setCountInStock(int countInStock) {
		this.countInStock = countInStock;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getNumReviews() {
		return numReviews;
	}

	public void setNumReviews(int numReviews) {
		this.numReviews = numReviews;
	}
	

}
