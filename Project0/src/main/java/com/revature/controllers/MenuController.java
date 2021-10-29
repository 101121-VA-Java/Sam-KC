package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.models.UserType;
import com.revature.services.UserAuth;

public class MenuController {
	Scanner sc = new Scanner(System.in);
	CustomerMenu customerMenu = new CustomerMenu();
	EmployeeMenu employeeMenu = new EmployeeMenu();

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
		boolean validData = false;
		String name = "";
		String username = "";
		String password = "";
		while(run) {		
		while (!validData) {		
		System.out.println("Enter your name:");
		name = sc.nextLine();
		System.out.println("Enter your username:");
		username = sc.nextLine();
		System.out.println("Enter your password:");
		password = sc.nextLine();
		
		if ((username.length() < 4 && password.length() < 4)) {
		System.out.println("username & password must have at least 4 characters:");
		}
		else {
			validData = true;
		}
		}
		User u = new User(name, username, password, UserType.CUSTOMER);
		UserAuth ua = new UserAuth();
		String returnVal = ua.register(u);
		if (returnVal == "true") {
			System.out.println("User Created");
			User.currentUser = u.getId();
			run = false;
		}
		else {
			validData = false;
			System.out.println(returnVal);
		}
		
		}
		
	}


	private void redirectLogin(Scanner sc) {
		
		//TODO : auth user
		
		User u = new User("sam", "skc","pass", UserType.EMPLOYEE);
		
		if (u.getUserType() == UserType.EMPLOYEE) {
			employeeMenu.employeeMenu(sc);
		}
		else {
			customerMenu.customerMenu(sc);
		}
		
	}
	

	
	
	
}