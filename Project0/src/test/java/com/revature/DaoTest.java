package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.models.Item;
import com.revature.models.User;
import com.revature.models.UserType;
import com.revature.repositories.itemsPostgres;
import com.revature.services.Items;
import com.revature.services.UserAuth;



@TestMethodOrder(OrderAnnotation.class)


public class  DaoTest {
	
	private static itemsPostgres id;
	
	
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
		id = new itemsPostgres();
		
	}

	@AfterAll
	public static void tearDown() {
		System.out.println("AfterAll");
	}

	@Order(1)	
	@Test	
	public void getPendingOffers() {
		boolean actual = false;
		try {
			if (id.getPendingOffers() != null) {
			actual = true;
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Order(2)		
	@Test	
	public void getWeeklyPayments() {
		boolean actual = false;
		try {
			if (id.getWeeklyPayments() != null) {
			actual = true;
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Order(3)		
	@Test	
	public void viewItems() {
		boolean actual = false;
		try {
			if (id.viewItems() != null) {
			actual = true;
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean expected = true;
		assertEquals(expected, actual);
	}
	@Order(4)		
	@Test	
	public void viewOwnedItems() {
		boolean actual = false;
		try {
			if (id.viewOwnedItems(0) != null) {
			actual = true;
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	
	
	
	
}
