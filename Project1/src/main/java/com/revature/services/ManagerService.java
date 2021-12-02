package com.revature.services;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repositories.ManagerDao;
import com.revature.repositories.ManagerPostgres;

public class ManagerService {
	
	private ManagerDao md;
	
	
	public ManagerService() {
		super();
		md = new ManagerPostgres();
	}
	
	public ArrayList<Reimbursement> viewResolvedRequests() {
		
		return md.viewResolvedRequests();
		
		}
	
	public ArrayList<Reimbursement> viewPendingRequests() {
		return md.viewPendingRequests();
	}
	
	public ArrayList<User> viewAllEmployees(){
		return md.viewAllEmployees();
	}
	
	public ArrayList<Reimbursement> viewRequestByUsername(String username){
		return md.viewRequestByUsername(username);
	}
	
	public boolean updateRequestStatus(int reimbId, int statusId, int resolverID) {
		if (md.updateRequestStatus(reimbId, statusId, resolverID)) {
			return true;
		}
		return false;
	}
	
	

}
