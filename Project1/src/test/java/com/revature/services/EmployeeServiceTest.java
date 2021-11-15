package com.revature.services;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.repositories.EmployeeDao;




@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	
	@Mock
	private EmployeeDao ed;
	
	@InjectMocks
	private EmployeeService es;
	
	@Test
	public void submitReimbRequestTest() {
		Mockito.when(es.submitReimbRequest(null)).thenReturn(true);
		boolean expected = true;
		boolean actual = es.submitReimbRequest(null);
		assertEquals(expected, actual);
	}
	


}
