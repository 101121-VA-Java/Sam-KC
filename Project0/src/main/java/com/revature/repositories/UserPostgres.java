package com.revature.repositories;

import com.revature.models.User;
import com.revature.models.UserType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Properties;

import org.postgresql.util.PSQLException;

import java.sql.Statement;

public class UserPostgres implements UserDao {
	
	Connection conn = null;
	  private final static String DB_URL = "jdbc:postgresql://localhost:5432/Project0";
	  private final static String USER = "postgres";
	  private final static String PASS = "";

	public void connectDB() throws SQLException {
//		try {
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//            if (conn != null) {
//                System.out.println("Connected to database #1");
//                
//            }
//			}
//            catch (SQLException e) {
//			e.printStackTrace();
//			}       
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
	 } 
		
		
	
	public void testStatement() {
		
		
		String sql = "INSERT INTO Users VALUES ('DEFAULT','test','test','test','test');";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void addUser(User u) throws SQLException{
		connectDB();		
		
		//String userId = "'" + "1552" + "' , ";	
		String name = "'" + u.getName() + "' , ";
		String username = "'" + u.getUsername() + "' , ";
		String password = "'" + u.getPassword() + "' , ";
		String userType = "'" + u.getUserType() + "' ";		
		//String values =   userId + name + username + password + userType;
		String values =   name + username + password + userType;
		
		String sql = "INSERT INTO USERS (name, username, password, userType )VALUES  (" + values + ");";
		
		//for testing
		//String sql = "INSERT INTO USERS VALUES  (" + values + ");";
				 
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
	}

		// returns null if user doesn't exist
		// returns exception if something went wrong
	public User getUser(String username) throws SQLException {
		User u = null;
		connectDB();
		String sql = "SELECT * FROM USERS WHERE username = '" + username + "';" ;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while ( rs.next() ) {
			
			
			/// ---------------------- converting string to enums
			UserType usertype = null;
			if (rs.getString("userType").equals("CUSTOMER")) {
				usertype = UserType.CUSTOMER;
			}
			else if (rs.getString("userType").equals("EMPLOYEE")) {
				usertype = UserType.EMPLOYEE;
			}
			else if (rs.getString("userType").equals("MANAGER")) {
				usertype = UserType.MANAGER;
			}
			/// ----------------------
			
			
			u = new User(rs.getString("name"), rs.getString("username"), rs.getString("password"), usertype);
			u.setId(rs.getInt("userid"));
			return u;
		}

		return null;
	}

}
