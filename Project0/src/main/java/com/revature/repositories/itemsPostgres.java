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
		
		System.out.println(approval);
		conn = ConnectionUtil.getConnectionFromFile();
		String sql = "update USER_OFFERS set offerAccepted = ? "
				+ "where offerid = ?;";
		PreparedStatement ps = conn.prepareStatement(sql);		
		ps.setBoolean(1, approval);	
		ps.setInt(2, offerId);
		ps.executeUpdate();
		if (approval) {
			String sql2 = "delete from USER_OFFERS where offerid = ? and offerAccepted = false";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, itemId);
			ps2.executeUpdate();
		}

	}

	@Override
	public void removeItem(int itemId) throws IOException, SQLException {
		conn = ConnectionUtil.getConnectionFromFile();
		String sql = "delete from USER_OFFERS where itemid = ? ; delete from ITEMS where itemid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);		
		ps.setInt(1, itemId);
		ps.setInt(2, itemId);
		ps.executeUpdate();		
	}


	
	
	// No actual need to create this. removeItem is utilized in methods to reject all offers.
	@Override
	public boolean rejectAllOffers(int itemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public  ArrayList<Item> viewItems() throws SQLException, IOException {
		conn = ConnectionUtil.getConnectionFromFile();
		String sql = "select itemid, brand, model, batteryCapacity, facedetection, condition\r\n"
				+ "from items i\r\n"
				+ "except\r\n"
				+ "select i.itemid, brand, model, batteryCapacity, facedetection, condition\r\n"
				+ "from items i\r\n"
				+ "join user_offers uo on uo.itemid = i.itemid\r\n"
				+ "where uo.offeraccepted = true;" ;
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
		
//		String sql = "select distinct i.brand, i.model, i.batteryCapacity,"
//				+ "i.facedetection, i.Condition, i.itemid from "
//				+ "items i join USER_OFFERS o on o.userid =" + userId +  "where o.offerAccepted = true;" ;
		String sql = "select * from user_offers uo join users u on uo.userid "
				+ "=u.userid join items i on i.itemid  = uo.itemid where uo.offerAccepted = true;" ;	
		
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
		
		
//		String sql = "select * from user_offers uo join users u on uo.userid "
//				+ "=u.userid join items i on i.itemid  = uo.itemid;" ;	
		String sql = "select * from user_offers uo join users u on uo.userid "
				+ "=u.userid join items i on i.itemid  = uo.itemid where uo.payment_made = true;" ;	

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);		
		ArrayList<Payments> items = new ArrayList<Payments>();
		while ( rs.next() ) {	
			Payments i = new Payments(rs.getInt("itemid"), rs.getString("name"),
					rs.getString("brand"), rs.getString("model"), rs.getBoolean("payment_made"));			
			items.add(i);			
		}
		
		return items;
	}

	@Override
	public ArrayList<Payments> viewOwnedPayments(int userId) throws SQLException, IOException {
		conn = ConnectionUtil.getConnectionFromFile();		
		
		
		String sql = "select * from user_offers uo join users u on uo.userid"
				+ " =u.userid join items i on i.itemid  = uo.itemid where uo.payment_made = false"
				+ " and uo.offeraccepted = true;" ;
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);		
		ArrayList<Payments> items = new ArrayList<Payments>();
		while ( rs.next() ) {	
			Payments i = new Payments(rs.getInt("itemid"), rs.getString("name"),
					rs.getString("brand"), rs.getString("model"), false);			
			items.add(i);			
		}
		
		return items;
	}

	@Override
	public ArrayList<Offers> getWeeklyPayments() throws SQLException, IOException {
		conn = ConnectionUtil.getConnectionFromFile();
		String sql = "SELECT * FROM USER_OFFERS where payment_made = 'true'"
				+ " and date_created > DATE(NOW()) - INTERVAL '7' DAY ;" ;
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

	
	// --------------------------------- BONUS ------------------------------------------------
	@Override
	public void addItemWithImage(Item i, String imgUrl) throws SQLException, IOException {
		conn = ConnectionUtil.getConnectionFromFile();
		String sql = "INSERT INTO ITEMS (brand, model, batteryCapacity, facedetection,"
				+ " Condition, image_url )VALUES"
				+ "  ( ?, ?, ?, ?, ?, ? );";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,i.getBrand() );
		ps.setString(2, i.getModel());
		ps.setInt(3, i.getBatteryCapacity() );
		ps.setBoolean(4, i.isFaceDetection());
		ps.setString(5, i.getCondition());
		ps.setString(6, imgUrl);
		ps.executeUpdate();
		
	}

	@Override
	public String viewItemImage(int itemId) throws SQLException, IOException {
		conn = ConnectionUtil.getConnectionFromFile();
		String sql = "SELECT * FROM ITEMS WHERE itemid = " + itemId +" ;" ;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);		
		while ( rs.next() ) {	
			
		return rs.getString("image_url");
		}
		return "none";}

	// --------------------------------- BONUS ------------------------------------------------





}
