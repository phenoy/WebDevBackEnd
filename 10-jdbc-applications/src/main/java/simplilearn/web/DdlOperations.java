package simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simplilearn.utils.DatabaseConnection;

@WebServlet("/ddl-operations")
public class DdlOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//doGet chosen over doPost as we need a URL to access our WebServlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			Connection connection = DatabaseConnection.getConnection();
			
//			String sql = "CREATE TABLE DEPARTMENT (EID int(5), deptno char(20), deptName varchar(20) )";
//			String sql = "ALTER TABLE department add depthead varchar(45)";
			String sql = "drop table department";
			
			Statement statement = connection.createStatement();
			statement.execute(sql);

			statement.close();
			connection.close();
			
/*			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<h1>Table created successfully. </h1>");
			out.close();
			System.out.println("Table created successfully.");
*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
