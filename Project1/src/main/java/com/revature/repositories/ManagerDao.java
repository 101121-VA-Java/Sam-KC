package com.revature.repositories;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ManagerDao {

	//managers
	ArrayList<Reimbursement> viewPendingRequests();
	boolean updateRequestStatus(int reimbId, int statusId);
	ArrayList<Reimbursement> viewResolvedRequests();
	ArrayList<Reimbursement> viewRequest(String username);
	User viewUserInfo(User u);	
	User updateUserInfo(User u);
	User viewAllEmployees();
	
}
