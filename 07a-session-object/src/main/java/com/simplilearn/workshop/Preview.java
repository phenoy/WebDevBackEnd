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
 * Servlet implementation class Preview
 */
@WebServlet("/preview")
public class Preview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String email = request.getParameter("email");
		
		HttpSession session = request.getSession();
		String guestName = (String) session.getAttribute("guestName");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Preview</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3> Please confirm your information </h3>");
		out.println("<p>Guest Name 	: "+guestName+ "</p>");
		out.println("<p>Email		: "+email+"</p>");
		
//		Cookie saveEmailData = new Cookie("email", email);
//		response.addCookie(saveEmailData);
		
		out.println("<form action='savedata' method='post'>");
		out.println("<p><input type = 'submit' value='Save Data'/></p>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.println("");
		
	}

}
