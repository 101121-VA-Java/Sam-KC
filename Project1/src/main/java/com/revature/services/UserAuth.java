package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.repositories.UserPostgres;

public class UserAuth {

	private UserDao ud;
	
	public UserAuth() {
		super();
		ud = new UserPostgres();
	}
	
	// employees and manager	
	public String loginUser(String username, String password) {

		User loggedUser = null;		
		try {
			loggedUser = ud.getUser(username);
		} catch (SQLException e) {			
			return "Something went wrong";
		}
		catch (IOException e) {				
			if (e.getMessage().contains("duplicate key value")) {				
				return "User already exists";
				}			
		}
		// user exists, but still need to check if password match.
		if (loggedUser != null) {
			if (loggedUser.getPassword().equals(password)) {
				
				return "loggedin";
			}
			else { return "Invalid Password." ; }			
		}
		else { return "Username does not exist.";}

	}
	
	// employees and manager	
	public String loginUserByEmail(String email, String password) {

		User loggedUser = null;		
		try {
			loggedUser = ud.getUserByEmail(email);
		} catch (SQLException e) {			
			return "Something went wrong";
		}
		catch (IOException e) {				
			if (e.getMessage().contains("duplicate key value")) {				
				return "User already exists";
				}			
		}
		// user exists, but still need to check if password match.
		if (loggedUser != null) {
			if (loggedUser.getPassword().equals(password)) {
				
				return "loggedin";
			}
			else { return "Invalid Password." ; }			
		}
		else { return "Username does not exist.";}

	}
	
}
