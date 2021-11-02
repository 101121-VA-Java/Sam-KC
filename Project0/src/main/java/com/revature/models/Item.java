package com.revature.models;


public class Item {

private int itemId;
private String brand;
private String model;
private int batteryCapacity;
boolean faceDetection;
private String condition;


public Item ( String brand, String model, int batteryCapacity, boolean faceDetection, String condition ) {
this.brand = brand;
this.model = model;
this.batteryCapacity = batteryCapacity;
this.faceDetection = faceDetection;
this.condition = condition;

}



@Override
public String toString() {
	return "Item [itemId=" + itemId + ", brand=" + brand + ", model=" + model + ", batteryCapacity=" + batteryCapacity
			+ ", faceDetection=" + faceDetection + ", condition=" + condition + "]";
}



public int getItemId() {
	return itemId;
}


public void setItemId(int itemId) {
	this.itemId = itemId;
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


public int getBatteryCapacity() {
	return batteryCapacity;
}


public void setBatteryCapacity(int batteryCapacity) {
	this.batteryCapacity = batteryCapacity;
}


public boolean isFaceDetection() {
	return faceDetection;
}


public void setFaceDetection(boolean faceDetection) {
	this.faceDetection = faceDetection;
}


public String getCondition() {
	return condition;
}


public void setCondition(String condition) {
	this.condition = condition;
}


public static void add(Item i) {
	// TODO Auto-generated method stub
	
}





}

