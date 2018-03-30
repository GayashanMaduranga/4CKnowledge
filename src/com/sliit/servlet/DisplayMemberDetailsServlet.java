package com.sliit.servlet;

import java.awt.Checkbox;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sliit.datamodel.InterestsDao;
import com.sliit.entities.Interests;
import com.sliit.entities.Member;
import com.sliit.support.CheckBoxSelect;

/**
 * Servlet implementation class DisplayMemberDetails
 */
@WebServlet("/displaymemberdetails")
public class DisplayMemberDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayMemberDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		Member member = ((ArrayList<Member>)session.getAttribute("members")).get(id);
		session.setAttribute("selected_member", member);
		
		CheckBoxSelect select = new CheckBoxSelect();
		
		InterestsDao dao = new InterestsDao();
		Interests interests =  dao.getMemberInterest(id);
		
		
		request.getRequestDispatcher("memberDetails.jsp").forward(request, response);
	}

}
