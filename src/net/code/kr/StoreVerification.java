package net.code.kr;

import static net.code.kr.DB.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class StoreVerification {
	
	 public static  void VerificationCodeStore(int code,String email) throws SQLException {
	        Connection connection = getConnection();

         
         // Prepared statement to insert data
             String insertSql = " UPDATE members SET verification_code = ?  WHERE email = ?  " ;

            
             try (PreparedStatement prep = connection.prepareStatement(insertSql)) {
                     prep.setInt(1, code);
                     prep.setString(2, email);
                   
                      prep.executeUpdate();
                      
             }
	 }

}
