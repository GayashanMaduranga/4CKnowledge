package net.code.kr;


import static net.code.kr.DB.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CheckEmail {
	

    public static int FindUser(String email) throws SQLException{
        Connection connection = getConnection();
            
            String selectSql = "SELECT  STRCMP(t.Email, ?)" + "FROM test t " +"Where t.Email LIKE ?"  ;

            try(PreparedStatement prep = connection.prepareStatement(selectSql)) {
                
                 prep.setString(1, email);
                 prep.setString(2, "%"+email+"%");
            
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
    
   	 
}
