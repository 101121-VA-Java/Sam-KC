package com.revature.repositories;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ManagerDao {

	//managers
	ArrayList<Reimbursement> viewPendingRequests();
	boolean updateRequestStatus(int reimbId, int statusId, int resolverID);
	ArrayList<Reimbursement> viewResolvedRequests();
	ArrayList<Reimbursement> viewRequestByUsername(String username);
	ArrayList<User> viewAllEmployees();
	
}
