package com.revature.models;


public class User {

	private int id;
	private String name;
	private String username;
	private String password;
	private UserType userType;
	
	public User(String name, String username, String password, UserType user) {
		super();
		//TODO: gen ID
		//this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.userType = user;
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
