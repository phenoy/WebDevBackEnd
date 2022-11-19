package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Step2
 */
@WebServlet("/step2")
public class Step2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//Read the guest name
		String guestName = request.getParameter("guestName");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Greetings</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3> Welcome "+ guestName + "</h3>");
		out.println("<form action ='preview' method = 'post'>");
		//hidden element
		out.println("<input type='hidden' name='guestName' value='"+guestName+"'/>");
		out.println("<p>Enter Email ID:</p>");
		out.println("<p><input type='email' name='email'/> </p>");
		out.println("<p><input type='submit' value = 'preview'/> </p>");
		out.println("</form>");
		out.println("</body>");
		
		out.println("");
		out.println("</html>");
		
		
	}

}
