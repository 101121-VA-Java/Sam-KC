package com.revature.services;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.repositories.UserDaoList;
import com.revature.repositories.UserPostgres;


public class UserAuth {

	private UserDao ud;
	private UserPostgres up;
	private UserDaoList ul;
	
	
	public UserAuth() {
		up = new UserPostgres();
	}
	
	public String register(User u)  {
		String created = "Something went wrong.";
		try {
			return String.valueOf(up.addUser(u));
		}
//		catch (PSQLException e) {				
//			
//			//System.out.println(e.getErrorCode());
//			e.printStackTrace();
//		}
		catch (SQLException e) {				
			e.printStackTrace();
			//System.out.println(e.getErrorCode());
			//e.printStackTrace();
		}

		return created;
	}
	
	
	
	public boolean logIn(User u) {

		
		// for db
		if (up.loginUser(u)) {
			return true;
		}		
		return false;
		
		// for list
//		if (ul.loginUser(u)) {
//			return true;
//		}		
//		return false;
		
	}
	
	
	
	
}
