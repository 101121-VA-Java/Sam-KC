package com.revature.repositories;
import com.revature.models.User;


import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Item;
import com.revature.models.Offers;
import com.revature.models.Offers;

public interface ItemsDao {



	// Employee :
	
//	As an employee, I can add an item to the shop.
	void addItem(Item i) throws SQLException;
	
//	As an employee, I can accept or reject a pending offer for an item.
	Offers[] getPendingOffers();
	boolean changeOffer(int userId, int itemId);
	
	
//	As an employee, I can remove an item from the shop.
	boolean removeItem(int itemId);
	
//	As an employee, I can view all payments.
	Offers[] getPayments();
	
	
	
	// Customer :
	ArrayList<Item> viewItems() throws SQLException;
	ArrayList<Item> viewUnapprovedItems() throws SQLException;
	void makeOffer(User u, int itemId, double price) throws SQLException;
	
	//System:
	boolean rejectAllOffers(int itemId);
	
}
