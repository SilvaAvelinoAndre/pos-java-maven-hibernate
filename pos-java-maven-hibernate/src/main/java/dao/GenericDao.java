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
	
	public E pesquisar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		@SuppressWarnings("unchecked")
		E entity = (E) entityManager.find(entidade.getClass(), id); // vai buscar o id dentro da classe ou entidade.
		
		return entity;
		
	}

	
	public E pesquisarId(Long id, Class<E> entidade) {
		
		
		E entity = (E) entityManager.find(entidade, id); // vai buscar o id dentro da classe ou entidade.
		
		return entity;
		
	}
}
