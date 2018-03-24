package net.code.kr;
import static net.code.kr.DB.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Checkmail {
	

    public void UserGetLoad() throws SQLException{
        Connection connection = getConnection();
            
            String selectSql = "SELECT  STRCMP(t.Email, ?)" + "FROM test t "  ;

            try(PreparedStatement prep = connection.prepareStatement(selectSql)) {
                
                 prep.setString(1, "krishan@k.com");
               
            
              ResultSet  rs=prep.executeQuery();
            while(rs.next())
               { 
                 System.out.print(rs.getString(1));
               }
           } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
           
      
      }
}
