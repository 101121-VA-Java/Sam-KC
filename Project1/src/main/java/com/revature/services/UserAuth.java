package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.models.UserRole;
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
	public String loginUserByEmail(User u) {

		User loggedUser = null;		
		try {
			loggedUser = ud.getUserByEmail(u.getEmail());
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
			if (loggedUser.getPassword().equals(u.getPassword())) {
				UserRole ur = loggedUser.getRole();
				u.setRole(ur);
				return "loggedin";
			}
			else { return "Invalid Password." ; }			
		}
		else { return "Username does not exist.";}

	}
	
	public User getUserbyEmail(String email) {
		User u = null;
		try {
			u = ud.getUserByEmail(email);
		}
		catch (Exception e) {
			return null;
		};
		return u;
	}
	
}
