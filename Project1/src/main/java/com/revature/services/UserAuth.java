package com.revature.services;

import com.revature.repositories.UserDao;
import com.revature.repositories.UserPostgres;

public class UserAuth {

	private UserDao ud;
	
	public UserAuth() {
		super();
		ud = new UserPostgres();
	}
	
}
