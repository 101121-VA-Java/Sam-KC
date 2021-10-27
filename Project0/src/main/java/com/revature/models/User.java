package com.revature.models;

import java.util.ArrayList;
import java.util.Objects;

public class User {

	private int id;
	private String name;
	private String username;
	private String password;
	private UserType userType;
	private ArrayList<Payment> payment;
	
	public User(String name, String username, String password, UserType user) {
		super();
		//TODO: gen ID
		//this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.userType = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	
}