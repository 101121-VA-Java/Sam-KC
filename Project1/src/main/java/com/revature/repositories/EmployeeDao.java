package com.revature.repositories;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface EmployeeDao {
	
	//employees
	boolean submitReimbRequest(Reimbursement r);	
	ArrayList<Reimbursement> viewPendingReimb(User u);	
	Reimbursement viewResolvedReimb(User u);
		

}
