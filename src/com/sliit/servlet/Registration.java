package com.sliit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sliit.datamodel.MemberDao;
import com.sliit.entities.Member;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Registration() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member m = new Member();
		m.setFname(request.getParameter("fname"));
		m.setLname(request.getParameter("lname"));
		m.setEmail(request.getParameter("email"));
		
		MemberDao dao = new MemberDao();
		dao.insertMember(m);
		
		System.out.println("Inserted");
		
		request.getRequestDispatcher("/success.html").forward(request, response);
		
	}
	
}
