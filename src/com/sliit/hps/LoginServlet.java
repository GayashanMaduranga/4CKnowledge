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

import com.sliit.datamodel.MemberDao;
import com.sliit.encription.CryptWithMD5;
import com.sliit.entities.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

        response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		HttpSession session=request.getSession();
		
			
		String Email=request.getParameter("Email");
		String password=CryptWithMD5.cryptWithMD5(request.getParameter("pwd"));
		String DbPassword = null;
		try {
			DbPassword = GetUserPassword.getUserPassword(Email);
		
		
			
			
			if(DbPassword.equals(password))
		     	{
				session.setMaxInactiveInterval(30*60);
				// request.getRequestDispatcher("home.html").include(request, response);
				MemberDao dao = new MemberDao();
				
				Member user = dao.getMembersByEmail(Email);
			
				
				session.setAttribute("user", user);
				
				if(user.getUserLevel()!=Member.REGULAR_MEMBER) {
				 response.sendRedirect("memberManagementScreen.jsp");
				}else {
					response.sendRedirect("profileDetails.jsp");
				}
				 
				 
			    }
			else {
				out.print("<center><h2>Your Username or password invalid ,try again ! </h2></center>");

			      request.getRequestDispatcher("index.jsp").include(request, response);

				
			}
		
			
}   catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
