package com.revature;

import com.revature.controllers.MenuController;
import com.revature.repositories.UserPostgres;

public class Driver {
	
//	As a user, I can login.
//	As a user, I can register for a customer account.
//
//	As an employee, I can add an item to the shop.
//	As an employee, I can accept or reject a pending offer for an item.
//	As an employee, I can remove an item from the shop.
//	As an employee, I can view all payments.
//
//
//
//
//	As a customer, I can view the available items.
//	As a customer, I can make an offer for an item.
//
//
//	As the system, I update an item to an owned state when an offer is accepted.
//	As the system, I reject all other pending offers for an item when an offer is accepted.
//	As the system, I can calculate the weekly payment.

	public static void main(String[] args) {
//		UserPostgres up = new UserPostgres();
		MenuController mc = new MenuController();
		mc.mainMenu();
		
	}

}
