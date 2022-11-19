package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Preview
 */
@WebServlet("/preview")
public class Preview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String guestName = request.getParameter("guestName");
		String email = request.getParameter("email");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Preview</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3> Please confirm the details provided :</h3>");
		out.println("<p>Guest Name	: " +guestName+ "</p>");
		out.println("<p>Email ID	: " +email+ "</p>");
		out.println("");
		out.println("<form action ='savedata' method = 'post'>");
		out.println("<input type='hidden' name='guestName' value='"+guestName+"'/>");
		out.println("<input type='hidden' name='email' value='"+email+"'/>");
		out.println("<p> <input type='submit' value='Save Data' /> </p>");
		
		
		out.println("</form>");
		out.println("</body>");
		
		out.println("");
		out.println("</html>");
		
		
		
	}

}
