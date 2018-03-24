package net.code.kr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB {
    
	   
    public static Connection getConnection() throws SQLException
   {
     Connection con = null;
     
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/krishan","root","");
              return con ;
         }
     catch(ClassNotFoundException | SQLException e)
     { System.out.println(e);
     //JOptionPane.showMessageDialog(null,"my sql database server not started","Error",JOptionPane.ERROR_MESSAGE); 
     }
        return null;
   }
     
   
      public static void main(String[] args) throws SQLException {
    
    	 if( getConnection()!=null){
    		 System.out.println("OK");
    	 }
 
 
}
}