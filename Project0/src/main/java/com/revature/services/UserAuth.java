package com.revature.services;
import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.repositories.UserDaoList;
import com.revature.repositories.UserPostgres;


public class UserAuth {

	private UserDao ud;
	private UserPostgres up;
	private UserDaoList ul;
	
	
	public void register(User u) {
		up.addUser(u);
	}
	public boolean logIn(User u) {
		// for db
		
		
		// for list
		if (ul.loginUser(u)) {
			return true;
		}		
		return false;
		
	}
	
	
	
	
}
