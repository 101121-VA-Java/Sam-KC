package com.revature.repositories;

import com.revature.models.User;
import com.revature.models.UserType;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Properties;

import org.postgresql.util.PSQLException;

import java.sql.Statement;
import com.revature.util.ConnectionUtil;
public class UserPostgres implements UserDao {
	
	Connection conn = null;
		

	public void addUser(User u) throws SQLException, IOException{
			
		
		conn = ConnectionUtil.getConnectionFromFile();
		String sql = "INSERT INTO USERS (name, username, password, userType )VALUES"
				+ "  ( ?, ?, ?, ?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		String userType = u.getUsername();
		ps.setString(1, u.getName() );
		ps.setString(2, u.getUsername());
		ps.setString(3, u.getPassword());
		ps.setString(4, userType);		
		ps.executeUpdate();		

	}

		// returns null if user doesn't exist
		// returns exception if something went wrong
	public User getUser(String username) throws SQLException, IOException {
		User u = null;
		conn = ConnectionUtil.getConnectionFromFile();
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
