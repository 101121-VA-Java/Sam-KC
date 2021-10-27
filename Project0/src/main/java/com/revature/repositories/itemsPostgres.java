package com.revature.repositories;

import com.revature.models.Guitar;
import com.revature.models.Offers;
import com.revature.models.Payment;
import com.revature.models.User;

public class itemsPostgres implements ItemsDao {

	@Override
	public boolean addItem(User u, Guitar g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Offers[] getPendingOffers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeItem(Guitar g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Payment[] getPayments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guitar[] viewItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean makeOffer(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rejectAllOffers() {
		// TODO Auto-generated method stub
		return false;
	}

}
