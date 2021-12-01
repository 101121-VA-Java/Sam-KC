package com.revature.models;

public class Reimbursement {
	
	private int id;
	private double amount;
	private String submittedDate;
	private String resolvedDate;
	private String description;
	private String receipt;	
	private User author;	
	private User resolver; 	
	private ReimbursementStatus status;	
	private ReimbursementType type;
		
	

	public Reimbursement(double amount, String submittedDate, User author, ReimbursementStatus status,
			ReimbursementType type) {
		super();
		this.amount = amount;
		this.submittedDate = submittedDate;
		this.author = author;
		this.status = status;
		this.type = type;
	}
	public Reimbursement(double amount, String submittedDate, String description, User author, int status,
			int type) {
		super();
		this.amount = amount;
		this.submittedDate = submittedDate;
		this.description = description;
		this.author = author;
		this.status = new ReimbursementStatus(status);
		this.type = new ReimbursementType(type);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}
	public String getResolvedDate() {
		return resolvedDate;
	}
	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public User getResolver() {
		return resolver;
	}
	public void setResolver(User resolver) {
		this.resolver = resolver;
	}
	public ReimbursementStatus getStatus() {
		return status;
	}
	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}
	public ReimbursementType getType() {
		return type;
	}
	public void setType(ReimbursementType type) {
		this.type = type;
	}	
	
	

}
