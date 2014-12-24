package br.com.bookyard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;

import br.com.bookyard.service.FiltroLazyEntities;
import br.com.bookyard.util.ConnectionFactory;

public class GenericDao {

	EntityManager entityManager = new ConnectionFactory().openConnection();
	EntityTransaction tx = entityManager.getTransaction();
	
	public <E> void create(E object){
		tx.begin();
		entityManager.persist(object);
		tx.commit();
	}
	
	public <E> void update(E object){
		tx.begin();
		entityManager.merge(object);
		tx.commit();
	}
	
	public <E> void delete(E object){
		tx.begin();
		entityManager.remove(object);
		tx.commit();
	}
	
	@SuppressWarnings("unchecked")
	public <E> E findById(E objeto) { 
		PersistenceUnitUtil util = entityManager.getEntityManagerFactory().getPersistenceUnitUtil();
		Object idPrimaryKey = util.getIdentifier(objeto);
		
		if (idPrimaryKey == null) {
			return null;
		} else {
			return (E) entityManager.find(objeto.getClass(), idPrimaryKey);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <E> List<E> findEntities(E object){
		String consulta = "from " + object.getClass().getName();
		Query query = entityManager.createQuery(consulta);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public <E> List<E> findEntitiesLazy(FiltroLazyEntities filtro, E entity){
		String consulta = "from " + entity.getClass().getName();
		Query query = entityManager.createQuery(consulta);
		query.setFirstResult(filtro.getPrimeiroRegistro());
		query.setMaxResults(filtro.getQuantidadeRegistros());
		return query.getResultList();
	}
	
	public <E> Long findEntitiesLzyTotal(E entity) {
		String consulta = "select count(*) from " + entity.getClass().getName();
		Query query = entityManager.createQuery(consulta);
		return (Long) query.getSingleResult();
	}
	
}
