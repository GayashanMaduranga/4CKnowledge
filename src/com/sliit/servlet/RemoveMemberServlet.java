package com.sliit.servlet;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sliit.datamodel.MemberDao;
import com.sliit.entities.Member;

/**
 * Servlet implementation class removeMember
 */
@WebServlet("/removemember")
public class RemoveMemberServlet extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDao dao = new MemberDao();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Member member = ((ArrayList<Member>)request.getSession().getAttribute("members")).get(id);
		
		dao.removeMember(member);
		
		ArrayList<Member> members = null;
		HttpSession session = request.getSession();
		members = (ArrayList<Member>)dao.getAllMembers();
	 	session.setAttribute("members", members);
		
		response.sendRedirect("displaymembers");
		
		
	}

	

}
