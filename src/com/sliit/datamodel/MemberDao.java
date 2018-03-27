package com.sliit.datamodel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement ;
import com.sliit.entities.Member;

public class MemberDao {

	public List<Member> searchMembers(String searchString) {
		
	
		ArrayList<Member> members = null;
		Connection conn = DBConnection.getConnectionToDatabase();
		String query = "select * from members where fname like '%"+searchString+"%'";
	
		Statement stmt ;
		try {
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			members=(ArrayList<Member>)resultsetToArrayList(rs);
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return members;
	}
	
public List<Member> getAllMembers() {
		
		
		ArrayList<Member> members =null;
		Connection conn = DBConnection.getConnectionToDatabase();
		String query = "select * from members";
	
		Statement stmt ;
		try {
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			members=(ArrayList<Member>)resultsetToArrayList(rs);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return members;
		
		
	}
	

	private List<Member> resultsetToArrayList(ResultSet rs){
		
		Member member = null;
		ArrayList<Member> members = new ArrayList<>();
		
	try {
			
			while(rs.next()) {
			member = new Member();
			
			member.setFname(rs.getString("fname"));
			member.setLname(rs.getString("lname"));
			member.setEmail(rs.getString("email"));
			member.setAddress(rs.getString("address"));
			member.setMobile(rs.getString("mobile"));
			member.setMobile(rs.getString("home_tel"));
			member.setDob(rs.getDate("dob"));
			member.setUserLevel(rs.getInt("user_level"));
			member.setPassword(rs.getString("password"));	
			member.setVerificationCode(rs.getString("verification_code"));
			
			//add the rest
			
			
				members.add(member);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			
		return members;
		
	}

}
