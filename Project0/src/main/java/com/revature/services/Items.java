package com.revature.services;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.revature.models.Item;
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
			return false;
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
	}
	
	
}
