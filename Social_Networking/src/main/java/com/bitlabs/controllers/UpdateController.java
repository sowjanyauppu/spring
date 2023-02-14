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

@WebServlet("/userupdate")

public class UpdateController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("pwd");
		long mobilenumber=Long.parseLong(req.getParameter("mbno"));
		String dob=req.getParameter("dob");
		String city=req.getParameter("city");		
		
		try {
			HttpSession session=req.getSession();
			UserDetails r=new UserDetails();
			r.setId(((UserDetails)session.getAttribute("userdetails")).getId());
		    r.setName(name);
		    r.setEmail(email);
		    r.setPassword(password);
		    r.setMobilenumber(mobilenumber);
		    r.setDob(dob);
		    r.setCity(city);
		    
		    int b=new DaoImpl().update(r);
		    if(b>0) {
				session.setAttribute("statusmsg", "Your details have been updated successfully.");
				session.setAttribute("userdetails", r);
				resp.sendRedirect("updateuser.jsp");
			}
			else {
				session.setAttribute("statusmsg", "Something went wrong.....");
				resp.sendRedirect("register.jsp");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}

	

}
