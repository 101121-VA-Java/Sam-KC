package com.revature.services;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.repositories.UserDao;


@ExtendWith(MockitoExtension.class)
public class UserAuthServiceTest {
	
	@Mock
	private UserDao ud;
	
	@InjectMocks
	private UserAuth ua;
	
	@Test
	public void loginUserTest() {
		UserRole role = new UserRole(1, "EMPLOYEE");			
		User user = new User("user321", "pass321", "firstname",
				"lastname", "email", role);	
		try {
			Mockito.when(ud.getUser("user321")).thenReturn(user);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expected = "loggedin";
		String actual = ua.loginUser("user321", "pass321");
		assertEquals(expected, actual);
	}
	public void loginUserByEmailTest() {
		UserRole role = new UserRole(1, "EMPLOYEE");			
		User user = new User("user321", "pass321", "firstname",
				"lastname", "email", role);	
		try {
			Mockito.when(ud.getUserByEmail("user321")).thenReturn(user);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expected = "loggedin";
		String actual = ua.loginUser("user321", "pass321");
		assertEquals(expected, actual);
	}


}
