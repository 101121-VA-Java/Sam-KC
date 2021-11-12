package com.revature.models;

public class Reimbursement {
	
	private int id;
	private double amount;
	private boolean submitted;
	private boolean resolved;
	private boolean description;
	private String receipt;	
	private User author;	
	private User resolver; 	
	private ReimbursementStatus status;	
	private ReimbursementType type;	

}
