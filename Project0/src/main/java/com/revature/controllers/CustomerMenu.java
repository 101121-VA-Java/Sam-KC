package com.revature.controllers;

import java.util.Scanner;

public class CustomerMenu {
	
	
	public void customerMenu(Scanner sc) {
		
		boolean run = true;
		
		while(run) {
			System.out.println("Please select an option:");
			System.out.println("1: View avaliable items / Make Offer.");
			System.out.println("2: View items I own.");
			System.out.println("3: View remaining payments.");
			System.out.println("4: Go back");
			
			String input = sc.nextLine();
			
			switch(input) {
			case "1":
				itemsMenu(sc);
				break;
			case "2":
				viewOwnedItems(sc);
				break;
			case "3":
				viewRemainingPayment(sc);
				break;
			case "4":				
				run = false;
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
		
	
}
	
	private void itemsMenu(Scanner sc) {
		
		boolean run = true;
		
		while(run) {
			
			//TODO: Display Items
			System.out.println("~item list~");
			System.out.println("Please select an item number to make offer for:");
			System.out.println("or type exit to go back. ");			
			String input = sc.nextLine();
			
			
			if (!input.equals("exit")) {
			
			}
			else {
				run = false;
			}

		}		

	
}
	private void viewOwnedItems(Scanner sc) {
		//TODO: Query items and display them
		System.out.println("~ owned item list~");
	}
	private void viewRemainingPayment(Scanner sc) {
		//TODO: Query items and display them
		System.out.println("~ Paymenet Remaining ~");
	}
	
	
}
