package br.com.bookyard.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.bookyard.util.ConnectionFactory;

public class TelefoneDao extends GenericDao {

	EntityManager entityManager = new ConnectionFactory().openConnection();
	EntityTransaction tx = entityManager.getTransaction();
	
}
