package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step2")

public class Step2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//read the guest name
		String guestName = request.getParameter("guestName");
		
		//Create a cookie object
		Cookie guestData = new Cookie("guestName",guestName);
//		guestData.setMaxAge(1800);//setting max age for the cookie
		
		response.addCookie(guestData);//sending cookie to a browser through the HttpServletResponse obj
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cookie Session</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h3>Welcome "+guestName+"</h3>");
		
		out.println("<form action='preview' method='post'>");
		out.println("<p>Enter Email ID :</p>");
		out.println("<p><input type='email' name='email'</p>");
		out.println("<p><input type='submit' value='preview'></p>");
		out.println("</form>");
		
		out.println("</body>");
		out.println("</html>");

	}

}
