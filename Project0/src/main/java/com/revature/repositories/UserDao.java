package com.revature.repositories;
import java.io.IOException;
import java.sql.SQLException;

import com.revature.models.User;

public interface UserDao {

	
	void addUser(User u) throws SQLException, IOException;
	User getUser(String username) throws SQLException, IOException;
	
	
	
}
