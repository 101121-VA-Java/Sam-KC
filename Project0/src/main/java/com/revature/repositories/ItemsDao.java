package com.revature.repositories;
import com.revature.models.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Item;
import com.revature.models.Offers;
import com.revature.models.Payments;
import com.revature.models.Offers;

public interface ItemsDao {



	// Employee :
	
//	As an employee, I can add an item to the shop.
	void addItem(Item i) throws SQLException, IOException;
	
//	As an employee, I can accept or reject a pending offer for an item.
	ArrayList<Offers> getPendingOffers() throws IOException, SQLException;
	void changeOfferStatus(int offerId, boolean approval, int itemId) throws SQLException, IOException;
	
	
//	As an employee, I can remove an item from the shop.
	void removeItem(int itemId) throws IOException, SQLException;
	
//	As an employee, I can view all payments.
	ArrayList<Payments> viewAllPayments() throws SQLException, IOException;
	
	
	
	// Customer :
	ArrayList<Item> viewItems() throws SQLException, IOException;
	ArrayList<Item> viewOwnedItems(int userId) throws SQLException, IOException;
	ArrayList<Item> viewUnapprovedItems() throws SQLException, IOException;
	void makeOffer(User u, int itemId, double price) throws SQLException, IOException;
	ArrayList<Payments> viewOwnedPayments(int userId) throws SQLException, IOException;
	
	
	//System:
	boolean rejectAllOffers(int itemId);
	
}
