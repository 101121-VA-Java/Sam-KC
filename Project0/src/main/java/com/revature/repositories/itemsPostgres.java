package com.revature.repositories;

import com.revature.models.Guitar;
import com.revature.models.Offers;
import com.revature.models.User;

public class itemsPostgres implements ItemsDao {

	@Override
	public boolean addItem(Guitar g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Offers[] getPendingOffers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeOffer(int userId, int itemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeItem(int itemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Offers[] getPayments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guitar[] viewItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean makeOffer(User u, Guitar i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rejectAllOffers(int itemId) {
		// TODO Auto-generated method stub
		return false;
	}


}
