package com.revature.models;

import java.io.Serializable;

public class User implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8310072863195122425L;
	private int userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private UserRole role;
	
	
	public User() {
		
	}
	public User(String username, String password, String firstName, String lastName, String email, UserRole role) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}
	public User(String username, String password, String firstName, String lastName, String email, int role) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = new UserRole(role);
	}
	


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	
	
	
}
