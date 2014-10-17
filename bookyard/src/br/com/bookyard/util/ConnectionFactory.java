package br.com.bookyard.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private EntityManager entityManager;
	
	public EntityManager openConnection(){
		if (entityManager == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
			entityManager = emf.createEntityManager();
		}
		return entityManager;
	}
}
