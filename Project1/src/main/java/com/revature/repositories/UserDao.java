package com.revature.repositories;


import java.io.IOException;
import java.sql.SQLException;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface UserDao {

	
	//employees & manager
	User getUser (String u) throws  SQLException, IOException;
	


}
