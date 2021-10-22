package com.revature.models;


public abstract class Plant {
	
	private String name;
	private String color;
	private double height;	
	
	
	public Plant() {
		name = "Undefined";
		color = "Undefined";
		height = 0;
	}
	public Plant(String name, String color, double height) {
		this.name = name;
		this.color = color;
		this.height = height;
	}
	

	public String getPlantType() {
		return color;
	}
	public void setPlantType(String plantType) {
		this.color = plantType;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void grow() {
		System.out.println("Plant growing");
	}
	
	public String getName() {
		return name;
	}
	
	 

}