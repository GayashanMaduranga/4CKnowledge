package net.code.kr;



import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Krishan
 */
public class EmailSupplierInterface {
    
    



    
    
    
    
    static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
 
	public static void main(String args[]) throws AddressException, MessagingException {
    //generateAndSendEmail("krishan@ovi.com");
		//System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}
        
        
       public static String designMail(String e) throws SQLException
       
       {
    	 Random randomGen = new Random();
   		int randomInt = randomGen.nextInt(9000)+1000;
   		StoreVerification.VerificationCodeStore(randomInt,e);
   		
    	   String EMAIL="<center><h1><u>4C Knowledge</u></h1></center><table border=5 width=25% height=100% align=\"center\"> <tr><th>Verification Code</th></tr>" ;

           EMAIL +="<tr> <td><center>" + randomInt + "</center></td>  </tr> </table> ";
    	   
    	   return EMAIL;
    	   
    	   
       }
 
	public static void generateAndSendEmail(String Semail) throws AddressException, MessagingException, SQLException {
		String pass=designMail(Semail);
		
		
		
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
                mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(Semail)); //supplier email
		//generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("krishan.kr@ovi.com"));
		generateMailMessage.setSubject("4C Knowledge Reset Password");
		String emailBody = pass;
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "4c.knowledge@gmail.com", "sliit2020");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
    
    
}