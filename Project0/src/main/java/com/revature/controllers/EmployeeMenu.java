package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Item;
import com.revature.services.Items;

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
		
		
		System.out.println("Enter brand name");
		String brand = sc.nextLine();
		System.out.println("Enter model name");
		String model = sc.nextLine();		
		System.out.println("Enter battery Capacity");
		int battery = sc.nextInt();
		sc.nextLine();
		System.out.println("Does it support face detection?");
		String fd = sc.nextLine();
		System.out.println("Enter condition");
		String cond = sc.nextLine();
		boolean fdd = false;
		if (fd.equals("yes")){  fdd = true;}
		
		Item g = new Item(brand, model, battery, fdd, cond);		
		Items item = new Items();
		item.addItem(g);
		
		
		
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
