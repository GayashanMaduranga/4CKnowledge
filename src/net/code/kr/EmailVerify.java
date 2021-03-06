package net.code.kr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmailVerify
 */
@WebServlet("/emailVerify")
public class EmailVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailVerify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int code=Integer.parseInt(request.getParameter("Code"));
		HttpSession session=request.getSession(false);
		if(session!=null){
			
		String Email=(String)session.getAttribute("Email");
		int Vcode = 0;
		try {
			Vcode = GetVerifyCode.getUserVcode(Email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			if(Vcode!=-1)
			{
			
			if(code==Vcode)
		     	{
				session.setMaxInactiveInterval(60*3);
				 request.getRequestDispatcher("recoveryPassword.jsp").include(request, response);
			    }
			else {
			      request.getRequestDispatcher("email_verify.jsp").include(request, response);
			      session.setMaxInactiveInterval(60);

				}
			}
		
			
		
		}
		else{
			

			request.getRequestDispatcher("forget_password.jsp").include(request, response);
			out.print("<center><h1>Your session has timed out ,try again ! </h1></center>");
		}
		
	}
	}


