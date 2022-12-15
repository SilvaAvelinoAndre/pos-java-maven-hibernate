package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import pos.java.maven.hibernate.HibernateUtil;

public class GenericDao<E> {
	
	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	
	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();
		
		
	}

}
