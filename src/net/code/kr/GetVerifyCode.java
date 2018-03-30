package net.code.kr;

import static net.code.kr.DBConnection.getConnectionToDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetVerifyCode {
	
	 public static int getUserVcode(String email) throws SQLException{
	        Connection connection = getConnectionToDatabase();
	            
	            String selectSql = "SELECT verification_code " + "FROM  members " +" where email = ? "  ;

	            try(PreparedStatement prep = connection.prepareStatement(selectSql)) {
	                
	                 prep.setString (1, email);
	                
	            
	              ResultSet  rs=prep.executeQuery();
	            while(rs.next())
	            {
	                 return (rs.getInt(1));
	            }
	               
	            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}    
	            return -1;
	      
	      }
	
/*
public static void main(String[] args) throws SQLException
{
	System.out.println(getUserVcode("krishan.kr1996@gmail.com") ) ;

}*/
	 
	 
}
