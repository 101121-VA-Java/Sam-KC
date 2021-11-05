package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.models.User;
import com.revature.models.UserType;
import com.revature.services.Items;
import com.revature.services.UserAuth;



@TestMethodOrder(OrderAnnotation.class)


public class  AuthTest {
	

	private static UserAuth userAuth;
	@BeforeEach
	public void beforeEach() {
		System.out.println("Running before each test");
	}

	@AfterEach
	public void afterEach() {
		System.out.println("Running after each test");
	}

	@BeforeAll
	public static void setup() {
	
		userAuth = new UserAuth();
	}

	@AfterAll
	public static void tearDown() {
		System.out.println("AfterAll");
	}

	@Order(1)	
	@Test
	public void addUser() {
		User u = new User("name", "username", "password" , UserType.CUSTOMER);		
		String expected = "true";
		String actual = userAuth.register(u);
		assertEquals(expected, actual);
	}
	
	@Order(2)	
	@Test
	public void logInUser() {
		User u = new User("name", "username", "password" , UserType.CUSTOMER);		
		String expected = "loggedin";
		String actual = userAuth.logIn(u.getUsername(), u.getPassword());
		assertEquals(expected, actual);
	}
	
	
	
	
	
}
