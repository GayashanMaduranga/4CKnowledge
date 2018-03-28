package com.sliit.hps;

import static net.code.kr.DB.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetUserPassword {
	
	

	
	public static String getUserPassword(String email) throws SQLException {
        Connection connection = getConnection();
            
            String selectSql = "SELECT password " + "FROM  members " +" where email = ? "  ;
            String pass = null;
            try(PreparedStatement prep = connection.prepareStatement(selectSql)) {
                
                 prep.setString (1, email);
                
           
              ResultSet  rs=prep.executeQuery();
            while(rs.next())
            {
                 pass=rs.getString(1);
            }
            if(pass==null)
            {
            	pass="-999";
            }
        	return pass; 
            }
		
            catch(SQLException e) {
            	
            	return "-999"; 
            }
            
			  
            
      
      }
	

public static void main(String[] args) throws SQLException {
		
		System.out.print(getUserPassword("ddd@cc.com") );
		
	}
	
}
