package com.sliit.servlet;

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
 * Servlet implementation class DisplayProfileServlet
 */

@WebServlet("/profiledetails")
public class DisplayProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		HttpSession session = request.getSession();
//		int id = (int)session.getAttribute("user");
//		Member member = ((ArrayList<Member>)session.getAttribute("members")).get(id);
//		session.setAttribute("selected_member", member);
//		
//		
//		InterestsDao dao = new InterestsDao();
//		Interests interests =  dao.getMemberInterest(id);
		
		request.getRequestDispatcher("profileDetails.jsp").forward(request, response);
	}

}
