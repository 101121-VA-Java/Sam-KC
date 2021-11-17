package com.revature.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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

public class UserDaoTest {
	
	private UserDao ud = new UserPostgres();
	
	@Test
	public void loginUserTest() {
		boolean expected = true;
		boolean actual = false;
		try {
			User u = ud.getUser("user321");			
			actual = true;
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		assertEquals(expected, actual);
	}

}
