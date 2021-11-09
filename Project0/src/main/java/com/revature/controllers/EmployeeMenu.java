package com.revature.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.models.Item;
import com.revature.models.Offers;
import com.revature.models.User;
import com.revature.services.Items;

public class EmployeeMenu {
	InputValidator iv = new InputValidator();
	FileUpload uf = new FileUpload();
	public void employeeMenu(Scanner sc) {
		
		boolean run = true;
		
		while(run) {
			System.out.println("Please select an option: (Logged in as: " + User.currentUser.getUsername() + ")" );
			System.out.println("1: Add an item to the shop.");
			System.out.println("2: Accept/Reject Offers.");
			System.out.println("3: Remove an item from the shop.");
			System.out.println("4: View all payments");
			System.out.println("5: View Weekly payment");
			System.out.println("6: Go back to main menu");
			System.out.println("7: Add an item to the shop with image (Bonus feature)");
			
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
				viewWeeklyPayments(sc);
				break;
			case "6":				
				run = false;
				break;
			case "7":				
				addItemWithImage(sc);
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
		
	
}
	
	private void addItem(Scanner sc) {		
		
		
		System.out.println("Enter brand name");
		String brand = iv.validateString(sc, 1, 35);
		System.out.println("Enter model name");
		String model = iv.validateString(sc, 1, 35);	
		System.out.println("Enter battery Capacity (mAh)");
		int battery = iv.validateInt(sc);
		sc.nextLine();
		System.out.println("Does it support face detection?");
		boolean fd = iv.validateBoolean(sc);
		System.out.println("Enter condition");
		String cond = iv.validateString(sc, 1, 35);				
		Item g = new Item(brand, model, battery, fd, cond);		
		Items item = new Items();
		if (
		item.addItem(g)
		== false) {
			System.out.println("Could not add item");
		}
		else {
			System.out.println("Item added to shop");
		}
			
	}
	private void approveOffers(Scanner sc) {		
		Items item = new Items();
		ArrayList<Offers> listOffers = item.getPendingOffers();
		if (listOffers.size() != 0) {
			
		System.out.println("Select offer ID to approve/reject");
		int offerId = iv.validateInt(sc);
		sc.nextLine();
		System.out.println("Approve Offer? : please enter yes or no");
		boolean approval = iv.validateBoolean(sc);		
		if ( approval) {
			for (Offers o : listOffers) {
				if (o.getItemId() == offerId) {
					item.changeOfferStatus(offerId, true, o.getItemId());
				}
			}
			
		}
		}
		else {
			System.out.println("No offers have been made for any items by customers.");
		}
		
	}
	
	//TODO : Solve foreign key constraint
	private void removeItem(Scanner sc) {		
		
		Items li = new Items();
		ArrayList<Item> listitems = li.getItems();
		if (listitems.size() != 0) {			
			for (Item i : listitems) {				
				System.out.println(i);
			}
			
			System.out.println("Please select itemID to delete");
			int itemNum = iv.validateInt(sc);
			sc.nextLine();
			Items item = new Items();
			item.removeItem(itemNum);
			System.out.println("Item deleted");
		}
		else {
			System.out.println("No items found.");
		}
		
	}
	
	private void viewPayments(Scanner sc) {		
		
		Items li = new Items();
		li.viewAllPayments();
	}	
	private void viewWeeklyPayments(Scanner sc) {		
		
		Items li = new Items();
		li.calculateWeeklyPayment();
	}	
	
	//BONUS
	private void addItemWithImage(Scanner sc) {		
		
		
		System.out.println("Enter brand name");
		String brand = iv.validateString(sc, 1, 35);
		System.out.println("Enter model name");
		String model = iv.validateString(sc, 1, 35);	
		System.out.println("Enter battery Capacity");
		int battery = iv.validateInt(sc);
		sc.nextLine();
		System.out.println("Does it support face detection?");
		boolean fd = iv.validateBoolean(sc);
		System.out.println("Enter condition");
		String cond = iv.validateString(sc, 1, 35);				
		Item g = new Item(brand, model, battery, fd, cond);		
		Items item = new Items();
		
		boolean errors = false;
		String imgUrl = "";
		try {
			imgUrl = uf.postImg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			errors = true;
			e.printStackTrace();
		}
		
		if (errors == false) {
		if (item.addItemWithImage(g, imgUrl )== false) {
			System.out.println("Could not add item");
		}
		else {
			System.out.println("Item added to shop");
		}
		}
		else { System.out.println("Something went wrong 101"); }
	}

	
}
