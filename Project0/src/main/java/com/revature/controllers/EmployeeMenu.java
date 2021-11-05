package com.revature.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.models.Item;
import com.revature.models.Offers;
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
		if (
		item.addItem(g)
		== false) {
			System.out.println("Could not add item");
		}
		
		
		
	}
	private void approveOffers(Scanner sc) {		
		Items item = new Items();
		ArrayList<Offers> listOffers = item.getPendingOffers();
		System.out.println("Select offer ID to approve/reject");
		int offerId = sc.nextInt();
		sc.nextLine();
		System.out.println("Approve or Reject Offer?");
		String approval = sc.nextLine();
		if ( approval.equals("approve")) {
			for (Offers o : listOffers) {
				if (o.getItemId() == offerId) {
					item.changeOfferStatus(offerId, true, o.getItemId());
				}
			}
			
		}
		
	}
	
	//TODO : Solve foreign key constraint
	private void removeItem(Scanner sc) {		
		
		Items li = new Items();
		ArrayList<Item> listitems = li.getItems();
		if (listitems != null) {
			for (Item i : listitems) {
				System.out.println(i);
			}
			
			System.out.println("Please select itemID to delete");
			int itemNum = sc.nextInt();
			sc.nextLine();
			Items item = new Items();
			item.removeItem(itemNum);
		}
		else {
			System.out.println("Error retrieving data");
		}
		
	}
	
	private void viewPayments(Scanner sc) {		
		
		Items li = new Items();
		li.viewAllPayments();
	}
	
}
