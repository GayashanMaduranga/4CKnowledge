package net.code.krRegister;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
		
		
			
			if(code==Vcode)
		     	{
				session.setMaxInactiveInterval(60*5);
				 request.getRequestDispatcher("interest.html").include(request, response);
			    }
			else {
			      request.getRequestDispatcher("Register_email_verify.jsp").include(request, response);
			      session.setMaxInactiveInterval(20);

				}
			}
		
			
		
		
		else{
			
			out.print("<center><h1>Your session has timed out ,try again ! </h1></center>");

			request.getRequestDispatcher("Login.html").include(request, response);
		}
		
	}
		
		
		
		
	}

