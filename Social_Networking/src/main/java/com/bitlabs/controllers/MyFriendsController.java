package com.bitlabs.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitlabs.dao.DaoImpl;
import com.bitlabs.dao.UserDetails;


@WebServlet("/myfriends")
public class MyFriendsController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session=req.getSession();
		    List<UserDetails> users=new DaoImpl().myFriends(((UserDetails)session.getAttribute("userdetails")).getId());
		    if(users!=null) {
				session.setAttribute("friendsList", users);
				session.setAttribute("statusmsg","");
				resp.sendRedirect("myfriends.jsp");
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