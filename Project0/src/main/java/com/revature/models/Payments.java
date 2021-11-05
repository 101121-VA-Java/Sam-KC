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
	
	
}
