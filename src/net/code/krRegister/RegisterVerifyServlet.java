package net.code.krRegister;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.mail.Address;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.code.kr.GetVerifyCode;

/**
 * Servlet implementation class RegisterVerifyServlet
 */
@WebServlet("/RegisterVerifyServlet")
public class RegisterVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterVerifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int code=Integer.parseInt(request.getParameter("Code"));
		HttpSession session=request.getSession(false);
		if(session!=null){
			
		
		int Vcode = (Integer) session.getAttribute("Vcode");
		String Email=(String) session.getAttribute("Email");
		String Fname=(String) session.getAttribute("Fname");
		String Lname=(String) session.getAttribute("Lname");
		String Caddress=(String) session.getAttribute("CAddress");
		String mobile=(String) session.getAttribute("mobile");
		String HomeTel=(String) session.getAttribute("Hometel");
		String password=(String) session.getAttribute("password");
		String Dob=(String) session.getAttribute("dob");
		
			
			if(code==Vcode)
		     	{
				try {
					RegisterUserDataStore.DataStore(Fname,Lname,Email,Caddress,mobile,HomeTel,password,Dob);
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
				session.setMaxInactiveInterval(60*30);
				 request.getRequestDispatcher("interest.jsp").include(request, response);
			    }
			else {
			      request.getRequestDispatcher("Register_email_verify.jsp").include(request, response);
			      session.setMaxInactiveInterval(20);

				}
			}
		
			
		
		
		else{
			
			out.print("<center><h1>Your session has timed out ,try again ! </h1></center>");

			request.getRequestDispatcher("index.jsp").include(request, response);
		}
		
	}
		
		
		
		
	}

