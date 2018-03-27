package net.code.kr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResetpassServlet
 */
@WebServlet("/resetpassServlet")
public class ResetpassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetpassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		
      try {  String password=request.getParameter("password");
        String Cpassword=request.getParameter("confirmpassword");
		HttpSession session=request.getSession(false);
		if(session!=null){
     	String Email=(String)session.getAttribute("Email");
		
		
		
			if(password.equals(Cpassword))
			{
				Resetpassword.Resetpwd(password,Email);
			    request.getRequestDispatcher("reset_successfully.jsp").include(request, response);
			    out.print(" <center><h1>Password Reset Successful !</h1></center>");

				 session.setMaxInactiveInterval(20);
			   
					

			     

			
			}
			else{
				
			      request.getRequestDispatcher("recoveryPassword.html").include(request, response);
			      session.setMaxInactiveInterval(60);

				
			     }
			
		
		}
		
		else {
			
			request.getRequestDispatcher("forget_password.html").include(request, response);
			out.print("<center><h1>Your session has timed out ,try again ! </h1></center>");
			
	     	}
		
      }
		catch(Exception e){
			
			request.getRequestDispatcher("forget_password.html").include(request, response);
		}
		
	}

}
