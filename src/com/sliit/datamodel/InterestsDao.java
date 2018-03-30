package com.sliit.datamodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sliit.entities.Interests;
import com.sliit.entities.Member;

public class InterestsDao {

	
	public void updateInterests(Interests interests) {
		
		Connection conn = DBConnection.getConnectionToDatabase();
		PreparedStatement stmt ;
		
		String resetQuery = "DELETE FROM memberInterests WHERE member_id= ? ;";
		try {
		stmt = conn.prepareStatement(resetQuery);
		stmt = conn.prepareStatement(resetQuery);
		stmt.setInt(1, interests.getMid());
		stmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		String query = "INSERT INTO memberInterests (`interset_id`, `member_id`) VALUES (?, ?);";
		
		try {
			
			for(Integer interest_id:interests.getInterestId()) {
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, interest_id);
				stmt.setInt(2, interests.getMid());
				stmt.executeUpdate();
			}
			
			
			 conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public Interests getMemberInterest(int id) {
		
		Interests interests = new Interests();
		interests.setMid(id);
		
		Connection conn = DBConnection.getConnectionToDatabase();
		PreparedStatement stmt ;
		
		String query = "select * FROM memberInterests WHERE member_id= ? ;";
		try {
		stmt = conn.prepareStatement(query);
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		
		
		
		while(rs.next()) {
			interests.getInterestId().add(rs.getInt("interset_id"));
		}
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return interests;
	}
	
}
