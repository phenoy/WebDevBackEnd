package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class enterEmail
 */
@WebServlet("/enteremail")
public class enterEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//reads the guestName received from the previous page through HttpServletRequest object
		String guestName = request.getParameter("guestName");

		HttpSession session = request.getSession();
		//HttpServletRequest function returns a HttpSession object.
		
		session.setAttribute("guestName", guestName);
		
		//setting the response type to the client browser
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Guest Email</title></head>");
		
		out.println("<body>");
		out.println("<h3>Welcome "+guestName+" to your learnings.</h3>");
		
		out.println("<form method='post' action='/07a-session-object/preview'");
		out.println("<p>Enter Email ID :</p>");
		out.println("<p><input type='email' name='email'</p>");
		out.println("<p><input type='submit' value='Preview'></p>");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");	}

}
