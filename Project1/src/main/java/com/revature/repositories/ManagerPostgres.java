package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class ManagerPostgres implements ManagerDao {

	@Override
	public ArrayList<Reimbursement> viewPendingRequests() {
		
		String sql = "select * from ers_reimb r join ERS_USERS u on u.u_id = r.reimb_author where r.reimb_status_id = 1;";
		ArrayList<Reimbursement> pendingList = new ArrayList<Reimbursement>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
		PreparedStatement ps = conn.prepareStatement(sql);		
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ) {		
			
			User u = new User();
			u.setUsername(rs.getString("u_username"));
			
			Reimbursement reimb = new Reimbursement(rs.getDouble("reimb_amount"), rs.getString("reimb_submitted"), 
					rs.getString("reimb_description"),
					u, rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));
			reimb.setId(rs.getInt("reimb_id"));
			pendingList.add(reimb);
		}
		}
		catch (SQLException | IOException e) {			
			e.printStackTrace();			
		}
		return pendingList;
	}

	@Override
	public boolean updateRequestStatus(int reimbId, int statusId) {
		String sql = "update ERS_REIMB set reimb_status_id = ? where reimb_id = ?;";

		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusId);
			ps.setInt(2, reimbId);
			ps.executeUpdate();
			return true;
			
		} catch (SQLException | IOException e) {			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<Reimbursement> viewResolvedRequests() {
		String sql = "select * from ers_reimb r join ERS_USERS u on u.u_id = r.reimb_author where r.reimb_status_id = 2;";
		ArrayList<Reimbursement> pendingList = new ArrayList<Reimbursement>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
		PreparedStatement ps = conn.prepareStatement(sql);		
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ) {		
			
			User u = new User();
			u.setUsername(rs.getString("u_username"));
			
			Reimbursement reimb = new Reimbursement(rs.getDouble("reimb_amount"), rs.getString("reimb_submitted"), 
					rs.getString("reimb_description"),
					u, rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));
			reimb.setId(rs.getInt("reimb_id"));
			pendingList.add(reimb);
		}
		}
		catch (SQLException | IOException e) {			
			e.printStackTrace();			
		}
		return pendingList;
	}

	@Override
	public ArrayList<Reimbursement> viewRequest(String username) {
		String sql = "select * from ers_reimb r join ERS_USERS u on u.u_id = r.reimb_author where u.u_username = ?;";
		ArrayList<Reimbursement> pendingList = new ArrayList<Reimbursement>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
		PreparedStatement ps = conn.prepareStatement(sql);	
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ) {		
			
			User u = new User();
			u.setUsername(rs.getString("u_username"));
			
			Reimbursement reimb = new Reimbursement(rs.getDouble("reimb_amount"), rs.getString("reimb_submitted"), 
					rs.getString("reimb_description"),
					u, rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));
			reimb.setId(rs.getInt("reimb_id"));
			pendingList.add(reimb);
		}
		}
		catch (SQLException | IOException e) {			
			e.printStackTrace();			
		}
		return pendingList;
	}

	@Override
	public User viewAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User viewUserInfo(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUserInfo(User u) {
		// TODO Auto-generated method stub
		return null;
	}

}
