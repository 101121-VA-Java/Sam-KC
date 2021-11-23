package com.revature.models;

public class UserRole {

	private int roleId;
	private String role;		
	
	public UserRole(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}
	public UserRole(int id) {
		switch (id) {
		case 1:
			role = "employee";
			break;
		case 2:
			role = "manager";
			break;
		default:
			role = "unknown";
			// log here
			break;		
		}
			
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
