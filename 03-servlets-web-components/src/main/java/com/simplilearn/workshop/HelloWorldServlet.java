package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {
	
	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html"); 		//MIME Type
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>SimpliLearn Again</title>");
		out.println("</head>");
		out.println("<body>");
		
		Date today = new Date();
		out.println("<h2> Hello World --> Servlet </h2>");
		out.println("<h4>Today's Date: " + today + "</h4>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

}
