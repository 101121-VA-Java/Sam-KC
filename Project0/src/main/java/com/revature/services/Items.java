package com.revature.services;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.revature.models.Item;
import com.revature.models.Offers;
import com.revature.models.User;
import com.revature.repositories.itemsPostgres;

public class Items {

	private itemsPostgres id;
	
	public Items() {
		id = new itemsPostgres();
	}
	
	public boolean addItem(Item i) {
		
		try {
			id.addItem(i);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;		
	}
	public ArrayList<Item> getItems() {
		
		
		try {				
			return id.viewItems();
			//Iterator li = listitems.iterator();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;		
	}
	
	public void makeOffer(User u, int itemId, double price) {
		try {
			id.makeOffer(u, itemId, price);
			System.out.println("Offer made successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not make offer.");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Offers> getPendingOffers() {
		try {
			System.out.println(id.getPendingOffers());	
			return id.getPendingOffers();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void changeOfferStatus(int offerId, boolean approval, int itemId) {
		try {
			id.changeOfferStatus(offerId, approval, itemId);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void removeItem(int itemId) {
		try {
			id.removeItem(itemId);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viewOwnedItems(int userId) {
		try {				
			System.out.println(id.viewOwnedItems(userId));		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}
	//TODO: if null, print no payments
	public void viewAllPayments() {
		try {
			System.out.println(id.viewAllPayments());
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//TODO: if null, print no payments
	public void viewOwnedPayments(int userId) {
		try {
			System.out.println(id.viewOwnedPayments(userId));
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
