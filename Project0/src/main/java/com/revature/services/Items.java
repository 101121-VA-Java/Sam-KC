package com.revature.services;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.revature.controllers.ImageViewer;
import com.revature.models.Item;
import com.revature.models.Offers;
import com.revature.models.Payments;
import com.revature.models.User;
import com.revature.repositories.itemsPostgres;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Items {
	private static Logger log = LogManager.getRootLogger();
	private itemsPostgres id;
	
	public Items() {
		id = new itemsPostgres();
	}
	
	public boolean addItem(Item i) {
		
		try {
			id.addItem(i);
		} catch (SQLException e) {
			log.fatal("Fatal error while trying to add item.");
			e.printStackTrace();
			return false;
		}
		catch (IOException e) {
			log.fatal("Fatal error while trying to add item.");
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
			log.fatal("Fatal error while trying to get item.");
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			log.fatal("Fatal error while trying to get item.");
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
			log.fatal("Fatal error while trying to make offer.");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Offers> getPendingOffers() {
		try {
			displayListOffers(id.getPendingOffers());	
			
			return id.getPendingOffers();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			log.fatal("Fatal error while trying to get pending offer.");
			e.printStackTrace();
		}
		return null;
	}
	
	public void changeOfferStatus(int offerId, boolean approval, int itemId) {
		try {
			id.changeOfferStatus(offerId, approval, itemId);
			System.out.println("item status changed");
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			log.fatal("Fatal error while trying to change offer status.");
			e.printStackTrace();
		}
	}
	public void removeItem(int itemId) {
		try {
			id.removeItem(itemId);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			log.fatal("Fatal error while trying to remove item.");
			e.printStackTrace();
		}
	}
	
	public void viewOwnedItems(int userId) {
		try {				
			displayListItems(id.viewOwnedItems(userId));		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.fatal("Fatal error while trying to view owned item.");
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			log.fatal("Fatal error while trying to view owned item.");
			e.printStackTrace();
		}		

	}
	//TODO: if null, print no payments
	public void viewAllPayments() {
		try {
			displayListPayments(id.viewAllPayments());
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			log.fatal("Fatal error while trying to view all payment.");
			e.printStackTrace();
		}
	}
	
	public void calculateWeeklyPayment() {
		try {
			displayWeeklyPayment(id.getWeeklyPayments());
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			log.fatal("Fatal error while trying to calculate Weekly Payment.");
			e.printStackTrace();
		}
	}
	
	//TODO: if null, print no payments
	public void viewOwnedPayments(int userId) {
		try {
			displayListPayments(id.viewOwnedPayments(userId));
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			log.fatal("Fatal error while trying to view owned payment.");
			e.printStackTrace();
		}
	}
	
	public void displayListItems(ArrayList<Item> list) {
		int numLooped = 0;
		for (Item i : list) {
			System.out.println(i);
			numLooped++;
		}
		if (numLooped == 0) {
			System.out.println("0 Items to display");
		}
	}
	public void displayListPayments(ArrayList<Payments> list) {
		int numLooped = 0;
		for (Payments i : list) {
			System.out.println(i);
			numLooped++;
		}
		if (numLooped == 0) {
			System.out.println("0 Items to display");
		}
		
	}
	public void displayListOffers(ArrayList<Offers> list) {
		int numLooped = 0;
		for (Offers i : list) {
			System.out.println(i);
			numLooped++;
		}
		if (numLooped == 0) {
			System.out.println("0 Items to display");
		}
	}
	public void displayWeeklyPayment(ArrayList<Offers> list) {
		double sales = 0;;
		for (Offers i : list) {
			sales += i.getOffer();			
		}
		System.out.println("Total of $" + sales + " sales in past 7 days.");

	}
	
	
	// --------------------------------- BONUS ------------------------------------------------

	public boolean addItemWithImage(Item i, String imgUrl) {
		
		try {
			id.addItemWithImage(i, imgUrl);
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
	
	public void viewItemImage(int itemId) {

		try {
			ImageViewer.viewImage(id.viewItemImage(itemId));
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// --------------------------------- BONUS ------------------------------------------------

	
}
