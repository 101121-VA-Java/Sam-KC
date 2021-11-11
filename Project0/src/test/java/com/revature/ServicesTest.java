package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.models.Item;
import com.revature.models.Offers;
import com.revature.models.User;
import com.revature.models.UserType;
import com.revature.repositories.ItemsDao;
import com.revature.repositories.itemsPostgres;
import com.revature.services.Items;
import com.revature.services.UserAuth;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@TestMethodOrder(OrderAnnotation.class)


public class  ServicesTest {
	
	@Mock
	private itemsPostgres ip;
	
	@InjectMocks
	private Items itemService;
	
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Running before each test");
	}

	@AfterEach
	public void afterEach() {
		System.out.println("Running after each test");
	}

//	@BeforeAll
//	public static void setup() {
//		itemService = new Items();
//		ip = new itemsPostgres();
//	}

	@AfterAll
	public static void tearDown() {
		System.out.println("AfterAll");
	}

//	@Order(1)	
//	@Test
//	public void addItem() {
//		Item i = new Item("Sony", "X15", 1200, false, "New");
//		boolean actual = itemService.addItem(i);
//		boolean expected = true;
//		assertEquals(expected, actual);
//	}
//	
//	@Order(2)	
//	@Test
//	public void getItems() {
//		boolean actual = false;
//		if (itemService.getItems() != null) {
//		actual = true;
//		}
//		boolean expected = true;
//		assertEquals(expected, actual);
//	}
	

	@Order(3)	
	@Test
	public void getPendingOffers() {
		
//		ArrayList<Offers> offersAL = new ArrayList<Offers>();
//		Offers o = new Offers(0, 0, 0, 0, false, false);
//		try {
//			Mockito.when(ip.getPendingOffers()).thenReturn(offersAL);
//		} catch (IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		boolean actual = false;
		if (itemService.getPendingOffers() != null) {
		actual = true;
		}
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	
	
	
	
	
}
