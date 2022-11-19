package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

			System.out.println("Login");
			
			//read the parameters
			String username = request.getParameter("USER_NAME");
			String password = request.getParameter("PASSWORD");
			
			System.out.println("User Name:" + username);
			
			response.setContentType("text/html"); 		//MIME Type
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Login Page</title>");
			out.println("</head>");
			out.println("<body>");
			
			out.println("<h2>Welcome " +username + " to SimpliLearn portal</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();

	}

}
