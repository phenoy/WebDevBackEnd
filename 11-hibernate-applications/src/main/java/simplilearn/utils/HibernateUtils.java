package simplilearn.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//Purpose of this code is to create a SessionFactory object.
//We need to create SessionFactory objects through these different levels for security purposes.

public class HibernateUtils {
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
	//building a SessionFactory which enables us to create a session object
	//Session object is used to communicate with database, like the Connection object used in JDBC
		
		if (sessionFactory == null) {
			try {
				//load hibernate.cfg.xml
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
					
				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
				
				System.out.println("SessionFactory created.");
				Metadata metadata = metadataSources.getMetadataBuilder().build();
				
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("SessionFactory NOT created.");
				if(standardServiceRegistry != null) {
					StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
				}
			}
		}
		System.out.println("SessionFactory NOT AT ALL created.");
		return sessionFactory;
	}
}
