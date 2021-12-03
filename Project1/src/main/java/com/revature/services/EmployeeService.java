package com.revature.services;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repositories.EmployeeDao;
import com.revature.repositories.EmployeePostgres;
import com.revature.repositories.UserPostgres;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmployeeService {

	private static Logger log = LogManager.getRootLogger();
	private EmployeeDao ed;
	
	
	public EmployeeService() {
		super();
		ed = new EmployeePostgres();
	}
	
	public boolean submitReimbRequest(Reimbursement r) {		
		if (ed.submitReimbRequest(r)) {
			return true;
		}
		return false;		
		}
	
	
	public ArrayList<Reimbursement> viewPendingReimb(User u) {
		ArrayList<Reimbursement> reimbList = ed.viewPendingReimb(u);
		return reimbList;
		
	}
	public ArrayList<Reimbursement> viewResolvedReimb(User u) {
		ArrayList<Reimbursement> reimbList = ed.viewResolvedReimb(u);
		return reimbList;
		
	}
	
	public User viewAccountInfo(String username) {
		UserPostgres up = new UserPostgres();
		try {
			return up.getUser(username);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			log.fatal("Fatal error when viewing account information.");
			e.printStackTrace();
		}
		return null;		
	}
	

}
