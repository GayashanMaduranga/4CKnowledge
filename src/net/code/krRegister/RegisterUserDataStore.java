package net.code.krRegister;

import static com.sliit.datamodel.DBConnection.getConnectionToDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterUserDataStore {
	
	 public static  void DataStore(String Fname,String Lanme,String email,String add ,String mobile ,String Htel,String password,String Dob) throws SQLException {
	        Connection connection = getConnectionToDatabase();

      
      // Prepared statement to insert data
          String insertSql = " INSERT INTO members(fname,lname,email,address,mobile,home_tel,user_level,password,dob) VALUES(?,?,?,?,?,?,?,?,?)   " ;

         
          try (PreparedStatement prep = connection.prepareStatement(insertSql)) {
                
                  prep.setString(1, Fname);
                  prep.setString(2,Lanme);
                  prep.setString(3, email);
                  prep.setString(4,add);
                  prep.setString(5, mobile);
                  prep.setString(6, Htel);
                  prep.setInt(7,0);
                  prep.setString(8,password);
                  prep.setString(9,Dob);
                
                   prep.executeUpdate();
                   
          }
	 }

}
