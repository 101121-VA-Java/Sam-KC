package com.revature.models;

public class Payments {
	
	private int itemId;
	private String customerName;
	private String brand;
	private String model;
	private boolean paymentMade;
	
	public Payments(int itemId, String customerName, String brand, String model, boolean paymentMade) {
		super();
		this.itemId = itemId;
		this.customerName = customerName;
		this.brand = brand;
		this.model = model;
		this.paymentMade = paymentMade;
	}

	@Override
	public String toString() {
		return "Payments [itemId=" + itemId + ", customerName=" + customerName + ", brand=" + brand + ", model=" + model
				+ ", paymentMade=" + paymentMade + "]";
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isPaymentMade() {
		return paymentMade;
	}

	public void setPaymentMade(boolean paymentMade) {
		this.paymentMade = paymentMade;
	}
	
	
	
}
