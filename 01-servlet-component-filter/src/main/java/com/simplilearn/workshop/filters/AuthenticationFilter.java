package com.simplilearn.workshop.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/secured-servlet")
public class AuthenticationFilter implements Filter {

	public void destroy() {
		System.out.println("doFilter method is called in " + this.getClass().getName() );
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String ipAddress = request.getRemoteAddr();
		
		if(username.equals("phenoy") && password.equals("simplilearn")) {
			System.out.println("User logged in successfully " + ipAddress + " at " +
					new Date().toString());
			//pass the request along the filter chain
			chain.doFilter(request, response);
			//this command helps us to transfer the control from filter to servlet
		} else {
			PrintWriter out =  response.getWriter();
			out.println("<h3> Sorry!!! You are not authorized to access this resource. </h3>");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init method is called in " + this.getClass().getName()); 
	}

}
