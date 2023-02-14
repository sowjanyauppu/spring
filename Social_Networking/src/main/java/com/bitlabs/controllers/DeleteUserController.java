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

@WebServlet("/userdelete")

public class DeleteUserController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		
		try {
			HttpSession session=req.getSession();
			int b=new DaoImpl().delete(((UserDetails)session.getAttribute("userdetails")).getId());
		    if(b>0) {
				session.setAttribute("statusmsg", "User have been deleted successfully.");
				session.setAttribute("userdetails", "");
				resp.sendRedirect("index.jsp");
			}
			else {
				session.setAttribute("statusmsg", "Something went wrong.....");
				resp.sendRedirect("updateuser.jsp");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}

	

}
