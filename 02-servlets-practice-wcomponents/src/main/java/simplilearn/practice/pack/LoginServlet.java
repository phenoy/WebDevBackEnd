package simplilearn.practice.pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		System.out.println("Login --> Servlet");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Simplilearn Login Page</title>");
		out.println("</head>");
		
		out.println("<form method='post' action='/servlets-practice-wcomponents/LoggedIn'>");
		
		out.println("<body>");
		
		out.println("<h1 style='color: green'>Welcome to Simplilearn Login Page</h1>");
		out.println("<hr color='green' size='3'/>");
		
		out.println("<table>");
		out.println("<tr><td>User Name: </td>"+"<td><input type='text' name = 'ÜSER_NAME'/></td></tr>");
		out.println("<tr><td>Password: </td>"+"<td><input type='password' name = 'PASSWORD'/></td></tr>");
		out.println("<tr><td>&nbsp</td>"+"<td><input type = 'submit' value = 'Login' /></td></tr>");
		out.println("</table>");
		
		out.println("</body>");
		out.println("</form>");
		out.println("</html>");
		out.close();
		
	}
}

/*
<form method="post" action="/login">		
<!-- Paragraph Tag will be <p>, whereas once backend has to be connected form tag should be used -->
	<table>		<!-- to display content in tabular structure -->
		<tr>		<!-- table row -->
			<td>User Name: </td>		<!-- table data tag -->
			<td> <input type = "text" name = "USER_NAME" /> </td>
				<!-- mentioning the input element with default type as text
				and name is identified as USER_NAME 
				USER_NAME & PASSWORD are the placeholders to contain the data we enter -->
			
		</tr>
		<tr>		<!-- table row -->
			<td>Password: </td>
			<td> <input type = "password" name = "PASSWORD" /> </td>
		</tr>
		
		<tr>		<!-- table row -->
			<td> &nbsp; </td>
			<td> <input type = "submit" value = "Login" /> </td>
		</tr>
		
	</table>
</form>
</body>
*/