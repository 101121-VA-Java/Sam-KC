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
import com.revature.models.UserRoles;
import com.revature.util.ConnectionUtil;

@TestMethodOrder(OrderAnnotation.class)

public class EmployeeDaoTest {
	private EmployeeDao ed = new EmployeePostgres();
	
	@Test
	public void submitReimbRequest() {		
		
		UserRoles role = new UserRoles(1, "EMPLOYEE");		
		ReimbursementType type = new ReimbursementType(1, "TRAVEL");
		ReimbursementStatus status = new ReimbursementStatus(1, "Created");
		
		User user = new User("username", "password", "firstname",
				"lastname", "email", role);		
		user.setUserId(1);
		double amount = 150;
		Reimbursement reimb = new Reimbursement(amount, "11/16/2021"
				, user, status, type);
		
		
		boolean actual = ed.submitReimbRequest(reimb);
		boolean expected  = true;
		assertEquals(expected, actual);
		
	}
	
	
	
}