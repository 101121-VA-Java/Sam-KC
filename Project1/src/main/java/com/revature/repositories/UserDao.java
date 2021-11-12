package com.revature.repositories;


import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface UserDao {

	
	//employees & manager
	boolean loginUser (User u);
	
	//employees	
	User viewUserInfo(User u);	
	User updateUserInfo(User u);
	
	
	// managers
	User viewAllEmployees();	
	
	

}
