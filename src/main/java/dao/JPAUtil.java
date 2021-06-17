package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

private static final String PERSISTENCE_UNI_NAME ="DirectorioPU";
	
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(factory == null) {
			try {
				factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNI_NAME);
			}catch(Exception e) {
			e.printStackTrace();
			}
		}
		return factory;
	}
	public static void shutdown() {
		if(factory != null) {
			factory.close();
		}
	}
}
