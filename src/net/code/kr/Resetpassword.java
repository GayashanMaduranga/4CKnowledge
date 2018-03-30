package net.code.kr;

import static net.code.kr.DBConnection.getConnectionToDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sliit.encription.CryptWithMD5;

public class Resetpassword {
	 public static  void Resetpwd(String pass,String email) throws SQLException {
	        Connection connection = getConnectionToDatabase();

      
      // Prepared statement to insert data
          String insertSql = " UPDATE members SET password = ?  WHERE email = ?  " ;

         
          try (PreparedStatement prep = connection.prepareStatement(insertSql)) {
        	  	pass = CryptWithMD5.cryptWithMD5(pass);
                  prep.setString(1, pass);
                  prep.setString(2, email);
                
                   prep.executeUpdate();
                   
          }
	 }

}
