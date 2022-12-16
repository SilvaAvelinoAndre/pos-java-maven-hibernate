package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

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
	public E updateMerge(E entidade) { 
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade); // método merge não só atualiza dados existentes se não existir ele cria.
		transaction.commit();
				
		return entidadeSalva;
	}
	
	public void deletarPorId(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		//Comando envia um SQL direto pro banco isto evita erros no processo
		entityManager.createNativeQuery("delete from " + entidade.getClass().getSimpleName().toLowerCase()+ " where id =" + id).executeUpdate();
		transaction.commit();
	}
	
	public List<E> listar(Class<E> entidade){
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		List<E> lista = entityManager.createQuery("from " + entidade.getName()).getResultList();
		transaction.commit();
		
		return lista;
		
	}
	
}
