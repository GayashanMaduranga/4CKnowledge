package com.sliit.hps;

import static net.code.kr.DB.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InterestStrore {
	
	 public static  void DataStore(String Email,String interest) throws SQLException {
	        Connection connection = getConnection();

   
   // Prepared statement to insert data
       String insertSql = " INSERT INTO memberInterests(interset_id,member_id) VALUES(?,?)   " ;
       String selectSql = " SELECT mid FROM members WHERE email=?   " ;

      
       try (PreparedStatement prep = connection.prepareStatement(selectSql);PreparedStatement prep2 = connection.prepareStatement(insertSql)) {
             
    	   String id = null;
    	      prep.setString(1, Email);
    	   		ResultSet  rs=prep.executeQuery();
    	   		while(rs.next())
    	   		{
    	   			id=rs.getString(1) ;
    	   		}
               prep2.setString(1, interest);
               prep2.setString(2,id);
               
             
                prep2.executeUpdate();
                
       }
	 }


	 
	 public static void main(String[] args) throws SQLException {
		 DataStore("krishan.kr1996@gmail.com","1");
		 DataStore("krishan.kr1996@gmail.com","3");
		 
	 }
	 
}
