package com.revature.services;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repositories.EmployeeDao;
import com.revature.repositories.EmployeePostgres;
import com.revature.repositories.UserPostgres;

public class EmployeeService {

	
	private EmployeeDao ed;
	
	
	EmployeeService() {
		super();
		ed = new EmployeePostgres();
	}
	
	public boolean submitReimbRequest(Reimbursement r) {		
		if (ed.submitReimbRequest(r)) {
			return true;
		}
		return false;		
		}
	
	
	public void viewPendingReimb(User u) {
		ArrayList<Reimbursement> reimbList = ed.viewPendingReimb(u);
		
	}
	
}
