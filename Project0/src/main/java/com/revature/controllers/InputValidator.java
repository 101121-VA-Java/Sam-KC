package com.revature.controllers;

import java.util.Scanner;




public class InputValidator {
	
	public String validateString(Scanner sc, int minChar, int maxChar) {
		
		String returnString = "";
		boolean validData = false;
		while (!validData) {				
		returnString = sc.nextLine();				
		if ((returnString.length() < minChar || returnString.length() > maxChar)) {
		System.out.println("Try again, Must have minimum of " + minChar + "and max of " + maxChar + "characters");
		}
		else {
			validData = true;
		}
		}
		return returnString;
	}
	
	public int validateInt(Scanner sc) {
		
		int returnInt = 0;
		boolean validData = false;
		while (!validData) {	
		try {
		returnInt = sc.nextInt();	
		validData = true;
		}
		catch (Exception e) {
			System.out.println("Please enter a proper number.");
			validData = false;
			sc.nextLine();
		}
			
		}
		return returnInt;
	}
	public double validateDouble(Scanner sc) {
		
		double returnDouble = 0;
		boolean validData = false;
		while (!validData) {	
		try {
		returnDouble = sc.nextDouble();	
		validData = true;
		}
		catch (Exception e) {
			System.out.println("Please enter a proper number.");
			validData = false;
			sc.nextLine();
		}
			
		}
		return returnDouble;
	}
	public boolean validateBoolean(Scanner sc) {
		boolean returnBool = false;
		boolean validData = false;
		while (!validData) {			
		String userInput = sc.nextLine();	
		if (userInput.equals("yes") ||userInput.equals("no") ) {
			
			if (userInput.equals("yes")) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			System.out.println("Please enter yes or no.");
			validData = false;
		}
		
		
		}		
		return false;
	}

}
