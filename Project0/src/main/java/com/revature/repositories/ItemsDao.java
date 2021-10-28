package com.revature.repositories;
import com.revature.models.User;
import com.revature.models.Guitar;
import com.revature.models.Offers;
import com.revature.models.Offers;

public interface ItemsDao {



	// Employee :
	
//	As an employee, I can add an item to the shop.
	boolean addItem(Guitar g);
	
//	As an employee, I can accept or reject a pending offer for an item.
	Offers[] getPendingOffers();
	boolean changeOffer(int userId, int itemId);
	
	
//	As an employee, I can remove an item from the shop.
	boolean removeItem(int itemId);
	
//	As an employee, I can view all payments.
	Offers[] getPayments();
	
	
	
	// Customer :
	Guitar[] viewItems();
	boolean makeOffer(User u, Guitar i);
	
	//System:
	boolean rejectAllOffers(int itemId);
	
}
