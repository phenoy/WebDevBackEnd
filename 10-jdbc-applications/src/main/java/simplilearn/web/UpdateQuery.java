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

@WebServlet("/update")
public class UpdateQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//doGet chosen over doPost as we need a URL to access our WebServlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			Connection connection = DatabaseConnection.getConnection();
			
			String sql = "UPDATE todos set description = ? WHERE id = ?";
			PreparedStatement prepStatement = connection.prepareStatement(sql);
			
			prepStatement.setString(1, "Learn to Sing");
			prepStatement.setLong(2, 4);
			
			prepStatement.executeUpdate();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<h1>Updated Record </h1>");
			out.close();
			System.out.println("Updated Record Successfully.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
