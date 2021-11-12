package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ReimbursementDao {
	
	//employees
	boolean submitReimbRequest(Reimbursement r);	
	Reimbursement viewPendingReimb(User u);	
	Reimbursement viewResolvedReimb(User u);
	
	
	//managers
	Reimbursement viewPendingRequests();
	boolean updateRequest(Reimbursement r);
	Reimbursement viewResolvedRequests();
	Reimbursement viewRequest(User u);

}
