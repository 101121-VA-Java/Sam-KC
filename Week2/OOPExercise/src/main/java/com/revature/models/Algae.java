package com.revature.models;

import com.revature.interfaces.aquatic;

public class Algae extends Plant implements aquatic  {
	
	private String speciesType;
	private boolean microscopic;
	
	
	public Algae() {
		super();
		this.speciesType = "Unknown";		
	}
	
	public Algae(String name, String color, double height, String speciesType, boolean microscopic) {
		super(name, color, height);
		this.speciesType = speciesType;
		this.microscopic = microscopic;
	}
	
	@Override
	public String toString() {
		return "Algae [speciesType=" + speciesType + ", microscopic=" + microscopic + "]";
	}

	@Override
	public void grow() {
		System.out.println("Algaes can double their size in 24 hours!");
	}

	public String getSpeciesType() {
		return speciesType;
	}

	public void setSpeciesType(String speciesType) {
		this.speciesType = speciesType;
	}

	public boolean isMicroscopic() {
		return microscopic;
	}

	public void setMicroscopic(boolean microscopic) {
		this.microscopic = microscopic;
	}

	public void waterType(String speciesType) {
		if (speciesType=="Red Algae") {
			System.out.println("This species thrives in salt water.");
		}
		
	}
	
	

}
