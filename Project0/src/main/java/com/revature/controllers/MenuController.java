package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.models.UserType;

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
				break;
			case "2":
				redirectMenu(sc);
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
	


	private void redirectMenu(Scanner sc) {
		
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