package com.revature.repositories;

import com.revature.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;

public class UserPostgres implements UserDao {
	
	Connection conn = null;
	  private final static String DB_URL = "jdbc:postgresql://localhost:5432/Project0";
	  private final static String USER = "postgres";
	  private final static String PASS = "";

	public UserPostgres() {
		try {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            if (conn != null) {
                System.out.println("Connected to database #1");
                
            }
			}
            catch (SQLException e) {
			e.printStackTrace();
			}       
		
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
	public int addUser(User u) {
		
		int result = 0;
		
		String userId = "'" + "20" + "' , ";
		String name = "'" + u.getName() + "' , ";
		String username = "'" + u.getUsername() + "' , ";
		String password = "'" + u.getPassword() + "' , ";
		String userType = "'" + u.getUserType() + "' ";		
		String values = userId + name + username + password + userType;
		
		String sql = "INSERT INTO Users VALUES (" + values + ");";
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public boolean loginUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

}
