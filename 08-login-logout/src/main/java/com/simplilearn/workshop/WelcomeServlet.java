package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * If confused about calling doGet/doPost we can call both and 
	 * call the processRequest function from each functions
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username = request.getParameter("name");//name is the parameter we set as part of the URL
		System.out.println("User Name: "+ username);
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		out.println("<form action='/login-logout/logout' method ='get'>");
		
		out.println("<h2> Hello "+username+"<h2>");
		out.println("<h3> Welcome to Simplilearn </h3>");
		
		out.println("<input type='submit' value='Logout'/>");
		out.println("</form>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request,response);
	}

}
