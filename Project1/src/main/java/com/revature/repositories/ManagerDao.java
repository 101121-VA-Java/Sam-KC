package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ManagerDao {

	//managers
	Reimbursement viewPendingRequests();
	boolean updateRequest(Reimbursement r);
	Reimbursement viewResolvedRequests();
	Reimbursement viewRequest(User u);
	User viewUserInfo(User u);	
	User updateUserInfo(User u);
	User viewAllEmployees();
	
}
