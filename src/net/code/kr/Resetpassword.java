package net.code.kr;

import static net.code.kr.DB.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Resetpassword {
	 public static  void Resetpwd(String pass,String email) throws SQLException {
	        Connection connection = getConnection();

      
      // Prepared statement to insert data
          String insertSql = " UPDATE members SET password = ?  WHERE email = ?  " ;

         
          try (PreparedStatement prep = connection.prepareStatement(insertSql)) {
                  prep.setString(1, pass);
                  prep.setString(2, email);
                
                   prep.executeUpdate();
                   
          }
	 }

}
