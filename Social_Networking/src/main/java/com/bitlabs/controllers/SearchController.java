package com.bitlabs.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitlabs.dao.DaoImpl;
import com.bitlabs.dao.Search;
import com.bitlabs.dao.UserDetails;


@WebServlet("/Search")
public class SearchController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fromAge=req.getParameter("fromAge");
		String toAge=req.getParameter("toAge");
		String city=req.getParameter("city");
		String gender=req.getParameter("gender");
		String marital=req.getParameter("marital");
		
		try {
			HttpSession session=req.getSession();
			Search s=new Search();
		    s.setFromAge(fromAge);
		    s.setToAge(toAge);
		    s.setCity(city);
		    s.setGender(gender);
		    s.setMarital(marital);
		    s.setId(((UserDetails)session.getAttribute("userdetails")).getId());
		   
		    List<UserDetails> users=new DaoImpl().search(s);
		    if(users!=null) {
				session.setAttribute("userList", users);
				session.setAttribute("statusmsg","");
				resp.sendRedirect("home.jsp");
			}
			else {
				session.setAttribute("statusmsg", "Something went wrong...");
				resp.sendRedirect("home.jsp");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
}
