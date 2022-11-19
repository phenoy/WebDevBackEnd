package simplilearn.practice.pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoggedInServlet
 */
@WebServlet("/LoggedIn")
public class LoggedInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {

			System.out.println("Login");
			response.setContentType("text/html"); 		//MIME Type
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Logged In Page</title>");
			out.println("</head>");
			out.println("<body>");
			
			out.println("<h2>Congrats for successfully Logging into SimpliLearn portal</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();
	}

}
