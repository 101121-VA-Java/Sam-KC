package com.revature.repositories;

import com.revature.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
	public boolean addUser(User u) throws SQLException{
		connectDB();
		boolean result = false;
		
		String userId = "'" + "1552" + "' , ";	
		String name = "'" + u.getName() + "' , ";
		String username = "'" + u.getUsername() + "' , ";
		String password = "'" + u.getPassword() + "' , ";
		String userType = "'" + u.getUserType() + "' ";		
		String values =   userId + name + username + password + userType;
		
		//String sql = "INSERT INTO USERS (name, username, password, userType )VALUES  (" + values + ");";
		String sql = "INSERT INTO USERS VALUES  (" + values + ");";
		Statement stmt = conn.createStatement();

//		try {
//			Statement stmt = conn.createStatement();
//			stmt.executeUpdate(sql);
//			result = true;
//		} 
//		catch (SQLException e) {
//			throw new SQLException();
//		}

		return result;
	}

	public boolean loginUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

}
