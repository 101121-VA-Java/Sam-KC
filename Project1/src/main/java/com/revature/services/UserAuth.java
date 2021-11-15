package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.repositories.UserPostgres;

public class UserAuth {

	private UserDao ud;
	
	public UserAuth() {
		super();
		ud = new UserPostgres();
	}
	
	public boolean loginUser(User u) {
		if (ud.loginUser(u)) {
			return true;
		}
		return false;		
	}
	
}
