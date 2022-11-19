package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/preview")
public class Preview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * doGet method is overriden here as the data is received through an anchor element
	 * <a href='----'></a>
	 * If the data was received through a form, doPost method had to get overridden.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String guestName = request.getParameter("guestName");
		String email = request.getParameter("email");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Preview</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Please confirm your information</h3>");
		out.println("<p>Guest Name	: "+guestName+"</p>");
		out.println("<p>Email ID	: "+email+"</p>");
		
		String queryString = "guestName="+guestName+"&email="+email;
		out.println("<a href='savedata?"+queryString+"'>Save Data</a>");
		out.println("");
		out.println("");
		out.println("</body>");
		out.println("</html>");
		
	}


}
