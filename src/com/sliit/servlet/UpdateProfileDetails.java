package com.sliit.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sliit.datamodel.InterestsDao;
import com.sliit.datamodel.MemberDao;
import com.sliit.entities.Interests;
import com.sliit.entities.Member;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/updateprofile")
public class UpdateProfileDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Member m = (Member)session.getAttribute("user");
		m.setFname(request.getParameter("fname"));
		m.setLname(request.getParameter("lname"));
		m.setEmail(request.getParameter("email"));
		m.setAddress(request.getParameter("address"));
		m.setHomeTel(request.getParameter("homeTel"));
		m.setDob(Date.valueOf(request.getParameter("dob")));
		
		MemberDao dao = new MemberDao();
		dao.updateMember(m);
		
		
		String[] interest;
		interest = request.getParameterValues("interest");
		
		Interests interestList = new Interests();
		interestList.setMid(m.getId());
		
		for(String val: interest) {
			
			interestList.getInterestId().add(Integer.parseInt(val));
			
		}
		
		
		InterestsDao iDao = new InterestsDao();
		iDao.updateInterests(interestList);
		
	
		request.getRequestDispatcher("/profileDetails.jsp").forward(request, response);
	}

}
