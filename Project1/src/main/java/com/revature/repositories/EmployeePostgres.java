package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.relation.Role;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import com.revature.models.UserRoles;
import com.revature.util.ConnectionUtil;

public class EmployeePostgres implements EmployeeDao {

	@Override
	public boolean submitReimbRequest(Reimbursement r) {
		String sql = "INSERT INTO ERS_REIMB (reimb_amount, reimb_author, "
				+ "reimb_status_id, reimb_type_id ) VALUES (?,?,?,?);";

		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1,r.getAmount());			
			ps.setInt(2, r.getAuthor().getUserId());
			ps.setInt(3, r.getStatus().getId());
			ps.setInt(4, r.getType().getId());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException | IOException e) {			
			e.printStackTrace();
			return false;
		}
				
		
	}

	/**
	 * DAO method to view pending reimbs.
	 * @param User object
	 * @return a List of Reimbs or null if none.
	 */
	@Override
	public ArrayList<Reimbursement> viewPendingReimb(User u) {
		String sql = "select * from ers_reimb r\r\n"
				+ "join ERS_USERS u on u.u_id = r.reimb_author \r\n"
				+ "where u.u_username = ? and r.reimb_status_id = 1;";
		ArrayList<Reimbursement> pendingList = new ArrayList<Reimbursement>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, u.getUsername());
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ) {		
			
			Reimbursement reimb = new Reimbursement(rs.getDouble("reimb_amount"), rs.getString("reimb_submitted"),
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
	public ArrayList<Reimbursement> viewResolvedReimb(User u) {
		String sql = "select * from ers_reimb r\r\n"
				+ "join ERS_USERS u on u.u_id = r.reimb_author \r\n"
				+ "where u.u_username = ? and r.reimb_status_id = 2;";
		ArrayList<Reimbursement> pendingList = new ArrayList<Reimbursement>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, u.getUsername());
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ) {		
			
			Reimbursement reimb = new Reimbursement(rs.getDouble("reimb_amount"), rs.getString("reimb_submitted"),
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



}
