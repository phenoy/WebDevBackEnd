package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Step3
 */
@WebServlet("/step3")
public class Step3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String guestName 	= request.getParameter("guestName");
		String email 		= request.getParameter("email");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Greetings</title>");
		out.println("</head>");
		out.println("<body>");
		
		String queryString = "guestName=" +guestName+"&email="+email;
		//URL Rewriting
		out.println("<p><a href='preview?"+queryString+"'>Preview Data</a></p>"
				+"<p><a href='savedata?"+queryString+"'> Save Data</a></p>");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("</body>");
		out.println("</html>");
	
	}

}
