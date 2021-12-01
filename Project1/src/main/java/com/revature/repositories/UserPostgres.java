package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.relation.Role;

import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.util.ConnectionUtil;

public class UserPostgres implements UserDao {

	public User getUser(String username) throws SQLException, IOException {
		User u = null;
		Connection conn = ConnectionUtil.getConnectionFromFile();
		String sql = "SELECT * FROM ERS_USERS u \r\n"
				+ "join ERS_USERS_ROLES r on u.user_role_id = r.user_role_id\r\n"
				+ "where u_username = ? ;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ) {
			// getting the role values
			int roleId = rs.getInt("user_role_id");
			String userRole = rs.getString("user_role");
			//getting the user values
			String u_username = rs.getString("u_username");		
			String u_password = rs.getString("u_password");	
			String u_firstName = rs.getString("u_firstname");	
			String u_lastName = rs.getString("u_lastname");	
			String u_email = rs.getString("u_email");	
			UserRole role = new UserRole(roleId, userRole);
			
			u = new User(u_username, u_password, u_firstName, u_lastName, u_email, role);			
			return u;
		}

		return null;
	}
	
	public User getUserByEmail(String email) throws SQLException, IOException {
		User u = null;
		Connection conn = ConnectionUtil.getConnectionFromFile();
		String sql = "SELECT * FROM ERS_USERS u \r\n"
				+ "join ERS_USERS_ROLES r on u.user_role_id = r.user_role_id\r\n"
				+ "where u_email = ? ;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ) {
			// getting the role values
			int roleId = rs.getInt("user_role_id");
			String userRole = rs.getString("user_role");
			//getting the user values
			String u_username = rs.getString("u_username");		
			String u_password = rs.getString("u_password");	
			String u_firstName = rs.getString("u_firstname");	
			String u_lastName = rs.getString("u_lastname");	
			String u_email = rs.getString("u_email");	
			UserRole role = new UserRole(roleId, userRole);
			
			u = new User(u_username, u_password, u_firstName, u_lastName, u_email, role);			
			return u;
		}

		return null;
	}
	
	
	public User viewUserInfo(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateUserInfo(User u) {
		String sql = "update ERS_USERS set u_firstname = ?, u_lastname = ?, u_password = ?, u_email = ?  where u_username = ?;";

		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getUsername());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException | IOException e) {			
			e.printStackTrace();
			return false;
		}
	
	}

	public User viewAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
