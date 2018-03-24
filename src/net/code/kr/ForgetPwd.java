package net.code.kr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.code.kr.EmailSupplierInterface;

/**
 * Servlet implementation class ForgetPwd
 */
@WebServlet("/forgetPwd")
public class ForgetPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect("http://www.google.com");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String Email=request.getParameter("Email");
			
		

		try {
			if(CheckEmail.FindUser(Email)==0)
			{
			try {
				EmailSupplierInterface.generateAndSendEmail(Email);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				HttpSession session=request.getSession();
				session.setAttribute("Email",Email);
				request.getRequestDispatcher("email_verify.html").include(request, response);

			      }
			}
			else {
				
				
			
				request.getRequestDispatcher("forget_password.html").include(request, response);
				out.print("Sorry, username not founded");
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		                       }

		
		

	}

}
