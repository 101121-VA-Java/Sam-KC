package com.revature.models;

public class Offers {
	
	private int offerId;
	private int userId ;		//user can make 
	private int itemId;	 //offer for an item
	private double offer;   // with the price
	private boolean offerAccepted; //which can be accepted or rejected by employee
	private boolean paymentMade;
	public Offers(int offerId, int userId, int itemId, double offer, boolean offerAccepted, boolean paymentMade) {
		super();
		this.offerId = offerId;
		this.userId = userId;
		this.itemId = itemId;
		this.offer = offer;
		this.offerAccepted = offerAccepted;
		this.paymentMade = paymentMade;
	}
	
	@Override
	public String toString() {
		return "Offers [offerId=" + offerId + ", userId=" + userId + ", itemId=" + itemId + ", offer=" + offer
				+ ", offerAccepted=" + offerAccepted + ", paymentMade=" + paymentMade + "]";
	}

	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public double getOffer() {
		return offer;
	}
	public void setOffer(double offer) {
		this.offer = offer;
	}
	public boolean isOfferAccepted() {
		return offerAccepted;
	}
	public void setOfferAccepted(boolean offerAccepted) {
		this.offerAccepted = offerAccepted;
	}

	public boolean isPaymentMade() {
		return paymentMade;
	}
	public void setPaymentMade(boolean paymentMade) {
		this.paymentMade = paymentMade;
	}
	
	
}
