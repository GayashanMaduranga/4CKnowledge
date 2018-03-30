package com.sliit.hps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sliit.encription.CryptWithMD5;

import net.code.kr.CheckEmail;
import net.code.kr.Resetpassword;
import net.code.krRegister.RegisterEmailVerificationInteraface;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Email=request.getParameter("Email");
		String Fname=request.getParameter("Fname");
		String Lname=request.getParameter("Lname");
		String Caddress=request.getParameter("CAddress");
		String mobile=request.getParameter("mobile");
		String HomeTel=request.getParameter("Hometel");
		String password=request.getParameter("password");
		String Cpassword=request.getParameter("Cpassword");
		String DoB=request.getParameter("dob");
		
		HttpSession session=request.getSession();

		int Vcode = 0;
		
		try {
			if(CheckEmail.FindUser(Email)!=0)
			{
				
				
				if(password.equals(Cpassword))
				{
					
					
					try {
						Vcode=RegisterEmailVerificationInteraface.generateAndSendEmail(Email);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally {
						
						password = CryptWithMD5.cryptWithMD5(password);
						session.setAttribute("Email",Email);
						session.setAttribute("Fname",Fname);
						session.setAttribute("Lname",Lname);
						session.setAttribute("CAddress",Caddress);
						session.setAttribute("mobile",mobile);
						session.setAttribute("Hometel",HomeTel);
						session.setAttribute("password",password);
						session.setAttribute("dob",DoB);
						session.setAttribute("Vcode",Vcode);
					
						
						session.setMaxInactiveInterval(60);

						request.getRequestDispatcher("Register_email_verify.jsp").include(request, response);

					      }
					
				 }
					else{
						out.print("<center><h1>Passwords are not matching!</h1></center>");

						request.getRequestDispatcher("index.jsp").include(request, response);
				        }
				
				
				
				
			
			
			
			
			}
			else {
				
				out.print("<center><h1>Already you have acoount</h1></center>");

				request.getRequestDispatcher("index.jsp").include(request, response);
			
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		                       }

		
		

	}
		
	}
