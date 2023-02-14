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
import com.google.protobuf.Internal.ListAdapter.Converter;


@WebServlet("/reject")
public class RejectController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session=req.getSession();
		    boolean b=new DaoImpl().reject(((UserDetails)session.getAttribute("userdetails")).getId(),Integer.parseInt(req.getParameter("friendId")));
		    if(b) {
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