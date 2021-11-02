package com.revature.repositories;
import java.sql.SQLException;

import com.revature.models.User;

public interface UserDao {

	
	void addUser(User u) throws SQLException;
	User getUser(String username) throws SQLException;
	
	
	
}
