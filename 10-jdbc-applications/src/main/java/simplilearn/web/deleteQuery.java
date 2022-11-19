package simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simplilearn.utils.DatabaseConnection;

@WebServlet("/delete")
public class deleteQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//doGet chosen over doPost as we need a URL to access our WebServlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			Connection connection = DatabaseConnection.getConnection();
			
			String sql = "Delete from todos WHERE id =?";
			PreparedStatement prepStatement = connection.prepareStatement(sql);
			
			prepStatement.setLong(1, 4);
			
			prepStatement.executeUpdate();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<h1>Record Deleted</h1>");
			out.close();
			System.out.println("Deleted Record Successfully.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
