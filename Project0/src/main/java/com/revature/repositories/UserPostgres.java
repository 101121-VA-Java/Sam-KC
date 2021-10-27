package com.revature.repositories;

import com.revature.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;

public class UserPostgres implements UserDao {
	
	Connection conn = null;
	  private final static String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
	  private final static String USER = "postgres";
	  private final static String PASS = "";

	public UserPostgres() {
		try {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            if (conn != null) {
                System.out.println("Connected to database #1");
                testStatement();
            }
			}
            catch (SQLException e) {
			e.printStackTrace();
			}       
		
	 } 
		
		
	
	public void testStatement() {
		String sql = "CREATE DATABASE STUDENTS1";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int addUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean loginUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

}
