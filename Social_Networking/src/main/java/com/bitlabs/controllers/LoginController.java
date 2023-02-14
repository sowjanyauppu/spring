package com.bitlabs.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitlabs.dao.DaoImpl;
import com.bitlabs.dao.UserDetails;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("pwd");
		
		try {
			HttpSession session=req.getSession();
			UserDetails r=new UserDetails();
		    r.setEmail(email);
		    r.setPassword(password);
		   
		    UserDetails user=new DaoImpl().login(r);
		    if(user!=null && user.getId()>0) {
				session.setAttribute("userdetails", user);
				session.setAttribute("statusmsg","");
				resp.sendRedirect("home.jsp");
			}
			else {
				session.setAttribute("statusmsg", "Invalid username or passowrd..., please try again.");
				resp.sendRedirect("index.jsp");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}

	

}
