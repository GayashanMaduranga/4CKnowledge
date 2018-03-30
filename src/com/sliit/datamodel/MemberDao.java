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
//		String query = "select * from members where (fname like '%"+searchString+
//											"%' or lname like '%"+searchString+"%'";
		
		String query = "select * from members where concat(fname,' ',lname) like '%"+searchString+"%' ";
	
		Statement stmt ;
		try {
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			members=(ArrayList<Member>)resultsetToArrayList(rs);
			
			conn.close();
				
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
			
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return members;
		
		
	}


	public void removeMember(Member member) {
		
		Connection conn = DBConnection.getConnectionToDatabase();
		String query = "delete from members where mid = ?";
	
		PreparedStatement stmt ;
		try {
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, member.getId());
			 stmt.executeUpdate();
			
			
			 conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
public void updateMember(Member member) {
		
		Connection conn = DBConnection.getConnectionToDatabase();
		String query = "update members "
				+ " set fname = ?, "
				+ "lname = ?, "
				+ "email = ?, "
				+ "address = ?, "
				+ "mobile = ?, "
				+ "home_tel = ?, "
				+ "dob = ?, "
				+ "user_level = ? "
				+ "where mid = ? ";
		

		
//		String query = "update 4CKnowledge.members"
//				+ " set fname = ?,"
//				+ "lname = ?,"
//				+ "email = ?,"
//				+ "mobile = ?,"
//				+ "home_tel = ?"
//				+ "where mid = ?;";
	
		PreparedStatement stmt ;
		try {
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, member.getFname());
			stmt.setString(2, member.getLname());
			stmt.setString(3, member.getEmail());
			stmt.setString(4, member.getAddress());
			stmt.setString(5, member.getMobile());
			stmt.setString(6, member.getHomeTel());
			stmt.setDate(7, member.getDob());
			stmt.setInt(8, member.getUserLevel());
			stmt.setInt(9, member.getId());
			stmt.executeUpdate();
			
			
			 conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}


public void insertMember(Member member) {
	
	Connection conn = DBConnection.getConnectionToDatabase();
	String query = "insert into members("
			+ "fname,"
			+ "lname,"
			+ "email,"
			+ "address,"
			+ "mobile,"
			+ "home_tel,"
			+ "dob,"
			+ "user_level,"
			+ "password"
			+ ") values(?,?,?,?,?,?,?,?,?);";

	PreparedStatement stmt ;
	try {
		
		stmt = conn.prepareStatement(query);
		stmt.setString(1, member.getFname());
		stmt.setString(2, member.getLname());
		stmt.setString(3, member.getEmail());
		stmt.setString(4, member.getAddress());
		stmt.setString(5, member.getMobile());
		stmt.setString(6, member.getHomeTel());
		stmt.setDate(7, member.getDob());
		stmt.setInt(8, member.getUserLevel());
		stmt.setString(9, member.getPassword());
		
		stmt.executeUpdate();
		
		
		 conn.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
}
	private List<Member> resultsetToArrayList(ResultSet rs){
		
		Member member = null;
		ArrayList<Member> members = new ArrayList<>();
		
	try {
			
			while(rs.next()) {
			member = new Member();
			member.setId(rs.getInt("mid"));
			member.setFname(rs.getString("fname"));
			member.setLname(rs.getString("lname"));
			member.setEmail(rs.getString("email"));
			member.setAddress(rs.getString("address"));
			member.setMobile(rs.getString("mobile"));
			member.setHomeTel(rs.getString("home_tel"));
			member.setDob(rs.getDate("dob"));
			member.setUserLevel(rs.getInt("user_level"));
			member.setPassword(rs.getString("password"));	
			member.setVerificationCode(rs.getString("verification_code"));
			
			System.out.println(member.getHomeTel());
			
				members.add(member);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			
		return members;
		
	}
	
	

}
