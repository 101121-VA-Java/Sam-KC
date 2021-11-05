package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Item;
import com.revature.models.Offers;
import com.revature.models.Payments;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class itemsPostgres implements ItemsDao {
	Connection conn = null;
	


	@Override
	public void addItem(Item i) throws SQLException, IOException {
		conn = ConnectionUtil.getConnectionFromFile();
		String sql = "INSERT INTO ITEMS (brand, model, batteryCapacity, facedetection, Condition )VALUES"
				+ "  ( ?, ?, ?, ?, ? );";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,i.getBrand() );
		ps.setString(2, i.getModel());
		ps.setInt(3, i.getBatteryCapacity() );
		ps.setBoolean(4, i.isFaceDetection());
		ps.setString(5, i.getCondition());
		ps.executeUpdate();
	}

	@Override
	public ArrayList<Offers> getPendingOffers() throws IOException, SQLException {
		conn = ConnectionUtil.getConnectionFromFile();
		String sql = "SELECT * FROM USER_OFFERS where offerAccepted = 'false';" ;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<Offers> offersAL = new ArrayList<Offers>();
		while ( rs.next() ) {		
			Offers o = new Offers(rs.getInt("offerid"), rs.getInt("userid"),
					rs.getInt("itemid"), rs.getDouble("offer"), rs.getBoolean("offerAccepted"),
					rs.getBoolean("payment_made"));
			//o.(rs.getInt("itemid"));
			offersAL.add(o);			
		}
		return offersAL;
	}

	@Override
	public void changeOfferStatus(int offerId, boolean approval, int itemId) throws IOException, SQLException{
		conn = ConnectionUtil.getConnectionFromFile();
		String sql = "update USER_OFFERS set offerAccepted = ? "
				+ "where offerid = ?;";
		PreparedStatement ps = conn.prepareStatement(sql);		
		ps.setBoolean(1, approval);	
		ps.setInt(2, offerId);
		ps.executeUpdate();
		if (approval) {
			String sql2 = "delete from USER_OFFERS where itemid = ? and offerAccepted = ?";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, itemId);
			ps2.setBoolean(2, false);
			ps2.executeUpdate();
		}
	}

	@Override
	public void removeItem(int itemId) throws IOException, SQLException {
		conn = ConnectionUtil.getConnectionFromFile();
		String sql = "delete from ITEMS where itemid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);		
		ps.setInt(1, itemId);
		ps.executeUpdate();		
	}



	@Override
	public boolean rejectAllOffers(int itemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public  ArrayList<Item> viewItems() throws SQLException, IOException {
		conn = ConnectionUtil.getConnectionFromFile();
		String sql = "SELECT * FROM ITEMS ;" ;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);		
		ArrayList<Item> items = new ArrayList<Item>();
		while ( rs.next() ) {			
			Item i = new Item(rs.getString("brand"), rs.getString("model"),
					rs.getInt("batteryCapacity"), rs.getBoolean("facedetection"), 
					rs.getString("Condition"));
			i.setItemId(rs.getInt("itemid"));
			items.add(i);			
		}
		
		return items;
		
	}
	@Override
	public ArrayList<Item> viewUnapprovedItems() throws SQLException, IOException {
		conn = ConnectionUtil.getConnectionFromFile();
		String sql = "SELECT * FROM ITEMS WHERE;" ;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);		
		ArrayList<Item> items = new ArrayList<Item>();
		while ( rs.next() ) {			
			Item i = new Item(rs.getString("brand"), rs.getString("model"),
					rs.getInt("batteryCapacity"), rs.getBoolean("facedetection"), 
					rs.getString("Condition"));
			i.setItemId(rs.getInt("itemid"));
			items.add(i);			
		}
		
		return items;
	}


	@Override
	public void makeOffer(User u, int itemId, double price) throws SQLException, IOException {	
		
		conn = ConnectionUtil.getConnectionFromFile();
		String sql = "INSERT INTO USER_OFFERS (userid, itemid, offer)VALUES"
				+ "  ( ?, ?, ? );";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,u.getId() );
		ps.setInt(2, itemId);
		ps.setDouble(3, price );
		ps.executeUpdate();
		
	}

	@Override
	public ArrayList<Item> viewOwnedItems(int userId) throws SQLException, IOException {
		conn = ConnectionUtil.getConnectionFromFile();
		
		// get brand, model, batterycap , facedet, cond, from offer id where offer accepted = true
		
		String sql = "select distinct i.brand, i.model, i.batteryCapacity,"
				+ "i.facedetection, i.Condition, i.itemid from "
				+ "items i join USER_OFFERS o on o.userid =" + userId +  "where o.offerAccepted = true;" ;
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);		
		ArrayList<Item> items = new ArrayList<Item>();
		while ( rs.next() ) {			
			Item i = new Item(rs.getString("brand"), rs.getString("model"),
					rs.getInt("batteryCapacity"), rs.getBoolean("facedetection"), 
					rs.getString("Condition"));
			i.setItemId(rs.getInt("itemid"));
			items.add(i);			
		}
		
		return items;
		
	}

	@Override
	public ArrayList<Payments> viewAllPayments() throws SQLException, IOException {
		conn = ConnectionUtil.getConnectionFromFile();		
		
		
		String sql = "select distinct i.itemid, u.\"name\", "
				+ "i.brand, i.model from items i join USER_OFFERS o "
				+ "on o.payment_made = true join USERS u on u.userid > 0;" ;		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);		
		ArrayList<Payments> items = new ArrayList<Payments>();
		while ( rs.next() ) {	
			Payments i = new Payments(rs.getInt("itemid"), rs.getString("name"),
					rs.getString("brand"), rs.getString("model"), true);			
			items.add(i);			
		}
		
		return items;
	}

	@Override
	public ArrayList<Payments> viewOwnedPayments(int userId) throws SQLException, IOException {
		conn = ConnectionUtil.getConnectionFromFile();		
		
		
		String sql = "select distinct i.itemid, u.\"name\", "
				+ "i.brand, i.model from items i join USER_OFFERS o "
				+ "on o.payment_made = false join USERS u on u.userid = " + userId +";" ;
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);		
		ArrayList<Payments> items = new ArrayList<Payments>();
		while ( rs.next() ) {	
			Payments i = new Payments(rs.getInt("itemid"), rs.getString("name"),
					rs.getString("brand"), rs.getString("model"), true);			
			items.add(i);			
		}
		
		return items;
	}

	



	





}
