package com.revature.models;

public class ReimbursementStatus {
	
	private int id;
	private String status;
		
	
	public ReimbursementStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	public ReimbursementStatus(int id) {
		super();
		this.id = id;
		if (id == 1) {
		status = "pending";
		}
		else if (id == 2)  {
		status = "approved";
		}
		else if (id == 3) {
		status = "denied";
		}
		else {
			//log here
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}		
	
}
