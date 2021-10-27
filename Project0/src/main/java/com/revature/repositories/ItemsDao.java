package com.revature.repositories;
import com.revature.models.User;
import com.revature.models.Guitar;
import com.revature.models.Offers;
import com.revature.models.Payment;

public interface ItemsDao {

	
	// Employee :
	boolean addItem(User u, Guitar g);
	Offers[] getPendingOffers();
	boolean removeItem(Guitar g);
	Payment[] getPayments();
	
	// Customer :
	Guitar[] viewItems();
	boolean makeOffer(User u);
	
	//System:
	boolean rejectAllOffers();
	
}
