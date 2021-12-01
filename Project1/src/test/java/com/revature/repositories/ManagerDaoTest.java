package com.revature.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.util.ConnectionUtil;

@TestMethodOrder(OrderAnnotation.class)

public class ManagerDaoTest {
	
private ManagerDao md = new ManagerPostgres();
	
	@Test
	public void viewPendingRequests() {	
		// it works
		System.out.println(md.viewPendingRequests().toString());
		
	}
	
	@Test
	public void updateRequestStatus() {
		
		Reimbursement r = md.viewPendingRequests().get(0);
		r.setDescription("testing");
		// it works
		md.updateRequestStatus(r.getId(), 3);
				
	}
	@Test
	public void viewReimbByUsername() {
		// it works
		String reimb = md.viewRequest("user321").toString();
		System.out.println(reimb);
				
	}

}
