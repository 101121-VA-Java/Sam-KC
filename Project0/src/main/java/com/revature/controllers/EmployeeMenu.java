package com.revature.controllers;

import java.util.Scanner;

public class EmployeeMenu {

	public void employeeMenu(Scanner sc) {
		
		boolean run = true;
		
		while(run) {
			System.out.println("Please select an option:");
			System.out.println("1: Add an item to the shop.");
			System.out.println("2: Accept/Reject Offers.");
			System.out.println("3: Remove an item from the shop.");
			System.out.println("4: View all payments");
			System.out.println("5: Go back to main menu");
			
			String input = sc.nextLine();
			
			switch(input) {
			case "1":
				addItem(sc);
				break;
			case "2":
				approveOffers(sc);
				break;
			case "3":
				removeItem(sc);
				break;
			case "4":
				viewPayments(sc);
				break;
			case "5":				
				run = false;
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
		
	
}
	
	private void addItem(Scanner sc) {		
		
		//TODO: Add item.
		System.out.println("~Add item~");
	}
	private void approveOffers(Scanner sc) {		
		
		//TODO: View offers.
		System.out.println("~View offers~");
	}
	private void removeItem(Scanner sc) {		
		
		//TODO: Remove Item.
		System.out.println("~Remove item");
	}
	private void viewPayments(Scanner sc) {		
		
		//TODO: Display Payments.
		System.out.println("Display Payments");
	}
	
}
