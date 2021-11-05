package com.revature.services;
import java.io.IOException;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

import com.revature.models.User;
import com.revature.repositories.UserDao;
//import com.revature.repositories.UserDaoList;
import com.revature.repositories.UserPostgres;


public class UserAuth {

	private UserDao ud;
	private UserPostgres up;
	//private UserDaoList ul;
	
	
	public UserAuth() {
		up = new UserPostgres();
	}
	
	public String register(User u)  {
		String created = "Something went wrong.";
		try {
			up.addUser(u);
			return "true";
		}

		catch (SQLException e) {				
			if (e.getMessage().contains("duplicate key value")) {
				return "User already exists";
				}			
		}
		catch (IOException e) {				
	
		}
		return created;
	}
	
		
	public String logIn(String username, String password) {

		User loggedUser = null;
		// for db
		try {
			loggedUser = up.getUser(username);
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
				User.currentUser = loggedUser;
				return "loggedin";
			}
			else { return "Invalid Password." ; }
			
		}
		else { return "Username does not exist.";}
		
		
		
		// for list
//		if (ul.loginUser(u)) {
//			return true;
//		}		
//		return false;
		
	}
	
	
	
	
}
