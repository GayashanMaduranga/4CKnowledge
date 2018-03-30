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

/**
 * Servlet implementation class InterestServlet
 */
@WebServlet("/InterestServlet")
public class InterestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String[] interest;
		HttpSession session=request.getSession(false);

		
		if(session!=null)
		{
			
			interest = request.getParameterValues("interest");
			String Email=(String) session.getAttribute("Email");
				if (interest != null) 
		       {
		        for (int i = 0; i < interest.length; i++) 
		        {
		        	try {
						InterestStrore.DataStore(Email,interest[i]);
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        
		        }
		        
		    	request.getRequestDispatcher("index.jsp").include(request, response);
		       }
		       else {
		    	   response.getWriter().write("<center><h1>Registration Successful.Pleace login</h1></center>");
		    	    out.print("<center><h1>You should select at least one interest </h1></center>");

					request.getRequestDispatcher("interest.jsp").include(request, response);
		            }
		   
		}
		
   else{
			
			out.print("<center><h1>Your session has timed out ,try again ! </h1></center>");

			request.getRequestDispatcher("index.jsp").include(request, response);
		}
		
	}

}
