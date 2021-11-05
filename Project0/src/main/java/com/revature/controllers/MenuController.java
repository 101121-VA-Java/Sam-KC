package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.models.UserType;
import com.revature.services.UserAuth;


public class MenuController {
	Scanner sc = new Scanner(System.in);
	CustomerMenu customerMenu = new CustomerMenu();
	EmployeeMenu employeeMenu = new EmployeeMenu();
	InputValidator iv = new InputValidator();

	public void mainMenu() {
		boolean run = true;
		
		while(run) {
			System.out.println("Please select an option:");
			System.out.println("1: register");
			System.out.println("2: login");
			System.out.println("3: exit");
			
			String input = sc.nextLine();
			
			switch(input) {
			case "1":
				registerUser(sc);
				break;
			case "2":
				redirectLogin(sc);
				break;
			case "3":
				run = false;
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
		
		sc.close();
	}
	
	
	private void registerUser(Scanner sc) {
		boolean run = true;	
		String name = "";
		String username = "";
		String password = "";
		while(run) {		
				
		System.out.println("Enter your name:");
		name = iv.validateString(sc, 3, 15);
		System.out.println("Enter your username:");
		username = iv.validateString(sc, 3, 15);
		System.out.println("Enter your password:");
		password = iv.validateString(sc, 3, 15);	

		
		User u = new User(name, username, password, UserType.EMPLOYEE);
		UserAuth ua = new UserAuth();
		String returnVal = ua.register(u);
		if (returnVal == "true") {
			System.out.println("User Created");			
			run = false;
		}
		else {			
			System.out.println(returnVal);
		}
		
		}
		
	}


	private void redirectLogin(Scanner sc) {
		
		boolean run = true;
		String username = "";
		String password = "";
		while(run) {		
			System.out.println("Enter your username:");
			username = iv.validateString(sc, 3, 15);
			System.out.println("Enter your password:");
			password = iv.validateString(sc, 3, 15);
			UserAuth ua = new UserAuth();
			String authResult = ua.logIn(username, password);
			if (authResult.equals("loggedin")) {
				run = false;
				System.out.println("Welcome " + User.currentUser.getName());
				
				if (User.currentUser.getUserType() == UserType.CUSTOMER) {					
					customerMenu.customerMenu(sc);
				}
				else if (User.currentUser.getUserType() == UserType.EMPLOYEE) {
					employeeMenu.employeeMenu(sc);
				}
			}
			else {
				System.out.println(authResult);
			}
			
		}

		
	}
	

	
	
	
}