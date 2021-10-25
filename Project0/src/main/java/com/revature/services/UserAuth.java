package com.revature.services;
import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.repositories.UserPostgres;


public class UserAuth {

	private UserDao ud;
	private UserPostgres up;
	
	
	public void register(User u) {
		up.addUser(u);
	}
	public void logIn(User u) {
		up.loginUser(u);
	}
	
	
	
	
}
