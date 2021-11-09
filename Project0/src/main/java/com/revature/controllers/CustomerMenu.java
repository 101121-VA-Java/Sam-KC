package com.revature.controllers;

import java.util.ArrayList;
import java.util.Scanner;
import com.revature.models.Item;
import com.revature.models.User;
import com.revature.services.Items;


public class CustomerMenu {
	InputValidator iv = new InputValidator();
	
	public void customerMenu(Scanner sc) {
		
		boolean run = true;
		
		while(run) {
			System.out.println("Please select an option: (Logged in as: " + User.currentUser.getUsername()  + ")"  );
			System.out.println("1: View avaliable items / Make Offer.");
			System.out.println("2: View items I own.");
			System.out.println("3: View remaining payments.");
			System.out.println("4: Go back");
			System.out.println("5: View item image. (Bonus)");
			
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
			case "5":				
				viewItemImage(sc);
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
		
	
}
	
	private void itemsMenu(Scanner sc) {
		
		Items li = new Items();
		ArrayList<Item> listitems = li.getItems();
		if (listitems.size() != 0) {
			for (Item i : listitems) {
				System.out.println(i);
			}
			
			System.out.println("Please select itemID to make offer for:");
			int itemNum = iv.validateInt(sc);
			//sc.nextLine();
			System.out.println("Please enter the amount you would like to offer:");
			double itemPrice = iv.validateDouble(sc);
			sc.nextLine();
			
			Items i = new Items();
			i.makeOffer(User.currentUser, itemNum, itemPrice);
			
		}
		else {
			System.out.println("No items have been added to the shop yet.");
		}
	
}
	private void viewOwnedItems(Scanner sc) {
		Items item = new Items();
		item.viewOwnedItems(User.currentUser.getId());
	}
	private void viewRemainingPayment(Scanner sc) {
		Items item = new Items();
		item.viewOwnedPayments(User.currentUser.getId());
		
		
	}
	
	
	private void viewItemImage(Scanner sc) {
		
		Items li = new Items();
		ArrayList<Item> listitems = li.getItems();
		if (listitems.size() != 0) {
			for (Item i : listitems) {
				System.out.println(i);
			}
			
			System.out.println("Please select itemID you want to view:");
			int itemNum = iv.validateInt(sc);
			
			li.viewItemImage(itemNum);
			
		}
		else {
			System.out.println("No items have been added to the shop yet.");
		}
	
}
	
	
}
