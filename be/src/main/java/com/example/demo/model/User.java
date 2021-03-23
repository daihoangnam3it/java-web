package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "User")
public class User {
	@Id
	private String id;
	private String email;
	@JsonIgnore
	private String password;
	private String name;
	private Boolean isAdmin=false;
	
	public User() {
		super();
	}

	public User(String email, String password, String name, Boolean isAdmin) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.isAdmin = isAdmin;
	}

	public String getId() {
		return id;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	
}
