package com.revature.repositories;
import java.sql.SQLException;

import com.revature.models.User;

public interface UserDao {

	
	boolean addUser(User u) throws SQLException;
	boolean loginUser(User u);
	
	
	
}
