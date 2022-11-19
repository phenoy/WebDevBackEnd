package simplilearn.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import simplilearn.model.User;
import simplilearn.model.UserHistory;
import simplilearn.utils.HibernateUtils;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		//Retrieve the transaction
		session.beginTransaction();
		
		User user = new User();
		user.setName("Phenoy");
		user.addHistory(new UserHistory(new Date(),"Set name to Phenoy"));
		//user.getHistory().add(new UserHistory(new Date(),"Set name to Phenoy"));
		user.getProteinData().setGoal(250);
		user.addHistory(new UserHistory(new Date(),"Set goal to 250"));
		//user.getHistory().add(new UserHistory(new Date(),"Set goal to 250"));
		
		session.save(user);
		//the save() enables Hibernate to issue the insert statement. 
		//Else the 'user' will be in a transient state and won't get inserted.
		session.getTransaction().commit();
		
		session.beginTransaction();
		//Retrieve data from database
		User loadedUser = (User)session.get(User.class, 1);
		System.out.println("Name: "+ loadedUser.getName());
		System.out.println("Goal: "+ loadedUser.getProteinData().getGoal());
		
		for(UserHistory history: loadedUser.getHistory()) {
			System.out.println(history.getEntryTime().toString() + " " +history.getEntry());
		}
		
		//Manipulate the User
		loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal()+50);
		loadedUser.getHistory().add(new UserHistory(new Date(), "add 50 protein"));
		
		//auto updating - this command checks if the user was manipulated and if so, 
		//Hibernate issues the UPDATE command.
		session.getTransaction().commit();
		
		session.close();
		
		System.out.println("Obtained Session.");
	}
}
