package pos.java.maven.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	public static EntityManagerFactory  fabrica = null;
	
	static {
		init();
	}
	
	public static void init() {
		
		try {
			if(fabrica == null) {
				
				fabrica = Persistence.createEntityManagerFactory("pos-java-maven-hibernate");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static EntityManager getEntityManager() {
		return fabrica.createEntityManager();
	}
	public static Object getPrimaryKey(Object entidade) {
		return fabrica.getPersistenceUnitUtil().getIdentifier(entidade); // método retorna a chave primaria da entidade 
	}
	
}
