package com.revature.repositories;
import com.revature.models.User;

public interface UserDao {

	
	int addUser(User u);
	boolean loginUser(User u);
	
	
	
}
