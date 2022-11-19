package simplilearn.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static Connection getConnection() {
		Connection connection = null;
		
		String driver_class_name = "com.mysql.cj.jdbc.Driver";
		String user = "root";
		String password = "G0d$Child";
		String url = "jdbc:mysql://localhost:3306/studentdb?allowPublicKeyRetrieval=true&useSSL=false";
		//localhost given in url because MySQL is run in the local machine
		//3306 is the port number used while installing MySQL
		//SSL will be there, when JAVA application tries to connect with db and SSL would be turned ON.
		//Due to that, we may get some error. Hence, have to say that SSL was turned off.
		System.out.println("DB Connection 1");
		try {
			//Step #1: Load a driver class
			Class.forName(driver_class_name);
			System.out.println("Loading a driver class");
			//Step #2: Establish the connection
			connection = DriverManager.getConnection(url, user, password);
			//Establishing a connection with the database.
		} catch(ClassNotFoundException CNFe) {
			System.out.println(CNFe.getMessage());
		} catch(SQLException SQLe) {
			System.out.println(SQLe.getMessage());
		}
		
		return connection;
	}
}
