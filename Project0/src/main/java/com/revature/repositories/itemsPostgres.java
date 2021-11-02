package com.revature.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Item;
import com.revature.models.Offers;
import com.revature.models.User;


public class itemsPostgres implements ItemsDao {
	Connection conn = null;
	  private final static String DB_URL = "jdbc:postgresql://localhost:5432/Project0";
	  private final static String USER = "postgres";
	  private final static String PASS = "";
	
	public void connectDB() throws SQLException {    
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
	 } 

	@Override
	public void addItem(Item i) throws SQLException {
		connectDB();
		String brand = "'" + i.getBrand() + "' , ";
		String model = "'" + i.getModel() + "' , ";
		String batteryCap = "'" + i.getBatteryCapacity() + "' , ";
		String facedetection = "'" + i.isFaceDetection()  + "' , ";
		String cond = "'" + i.getCondition()  + "' ";			
		String values =   brand + model + batteryCap + facedetection + cond ;		
		String sql = "INSERT INTO ITEMS (brand, model, batteryCapacity, facedetection, Condition )VALUES  (" + values + ");";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
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
	public boolean rejectAllOffers(int itemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public  ArrayList<Item> viewItems() throws SQLException {
		connectDB();
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
	public ArrayList<Item> viewUnapprovedItems() throws SQLException {
		connectDB();
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
	public void makeOffer(User u, int itemId, double price) throws SQLException {
		connectDB();
		String userId = "'" + u.getId() + "' , ";
		String iid = "'" + String.valueOf(itemId) + "' , ";		
		String values = userId + iid + "'" + String.valueOf(price) + "'";
		String sql = "INSERT INTO USER_OFFERS (userid, itemid, offer)VALUES  (" + values + ");";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();		
		
	}



}
