package com.revature.repositories;
import com.revature.models.User;

public interface UserDao {

	
	int addUser(User u);
	int loginUser(User u);
	
	
	
}
