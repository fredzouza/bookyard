package br.com.bookyard.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;

import br.com.caelum.vraptor.util.StringUtils;
import br.com.fotosensores.fotosprint.global.Tabela;

public class GenDao {

	public final EntityManager entityManager;
	
	public GenericDao(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	
	/**
	 * Busca um objeto genérico pela chave primária
	 * 
	 * @param objeto
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <E> E find(E objeto) { 
		PersistenceUnitUtil util = entityManager.getEntityManagerFactory().getPersistenceUnitUtil();
		Object idPrimaryKey = util.getIdentifier(objeto);
		
		if (idPrimaryKey == null) {
			return null;
		} else {
			return (E) entityManager.find(objeto.getClass(), idPrimaryKey);
		}
	}

	/**
	 * Busca um objeto genérico pela chave campo
	 * 
	 * @param campo
	 * @param objeto
	 * @return
	 */
	public <E> E findBy(String campo, E objeto) {
       
		E doReturn = null;
		String campoGet = "get" + StringUtils.capitalize(campo);
			
		try {
			Object valor = objeto.getClass().getMethod(campoGet).invoke(objeto);
			Query query = entityManager.createQuery("select g FROM " + objeto.getClass().getName() + " g where g." + campo + " = :campo" );
			query.setParameter("campo", valor);
			
			doReturn = getResultAsSingle(query);
			
		} catch (Exception e) {

		} 		
        
        return doReturn;
	}
	
	/**
	 * Busca todos os elementos do tipo do objeto
	 * 
	 * @param objeto
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <E> List<E> findAll(E objeto) {

		Query query = entityManager.createQuery("select g FROM " + objeto.getClass().getName() + " g" );
			
		return query.getResultList();
	}
	
	/**
	 * Busca todos os elementos do tipo do objeto ordernados 
	 * 
	 * @param objeto
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <E> List<E> findAllOrdenados(E objeto) {

		Query query = entityManager.createQuery("select g FROM " + objeto.getClass().getName() + " g order by g.id asc"  );
			
		return query.getResultList();
	}

	/**
	 * Insere um elemento ao banco
	 * 
	 * @param objeto
	 * @return
	 */
	public <E> E insert(E objeto) {

		entityManager.persist(objeto);
		
		return objeto;
	}


	/**
	 * Faz o update de um elemento no banco
	 * 
	 * @param objeto
	 * @return
	 */
	public <E> E update(E objeto) {

		entityManager.merge(objeto);
		entityManager.flush();
		
		return objeto;
	}

	/**
	 * Exclui um elemento do banco
	 * 
	 * @param objeto
	 * @return
	 */
	public <E> E remove(E objeto) {

		entityManager.remove(objeto);
		entityManager.flush();
		
		return objeto;
	}
	
	/**
	 * Executa a query e retorna um elemento
	 * 
	 * @param query
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <E> E getResultAsSingle(Query query) {

		E resultado = (E) query.getSingleResult();
		
		return resultado;
	}

	/**
	 * Executa a query e retorna uma lista de elemento
	 * 
	 * @param query
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <E> List<E> getResultAsArray(Query query) {

		List<E> resultado = query.getResultList();
		
		return resultado;
	}

	public <E> Tabela<E> getPagina(String namedQuery, Integer quantidade, Integer pagina, Date inicio, Date fim, String filtro) {
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <E> Tabela<E> getPagina(final String namedQuery, final Integer quantidade, Integer pagina) {

		if (pagina == null) {			
			pagina = 0;
		}
		
		Tabela<E> resultado = new Tabela<E>();
		
		Query queryQuantidadePaginas = this.entityManager.createNamedQuery(namedQuery + "Total");			
		Number quantidadePaginas = (Number) queryQuantidadePaginas.getSingleResult();

		Integer total = quantidadePaginas.intValue() / quantidade;
		
		if ((quantidadePaginas.intValue() % quantidade) > 0 ) {
			
			total++;
		}
		
		resultado.setTotal(total);

		Query queryPagina = this.entityManager.createNamedQuery(namedQuery);	
		queryPagina.setFirstResult(quantidade * pagina);
		queryPagina.setMaxResults(quantidade);

		resultado.setTabela(queryPagina.getResultList()); 
			
		return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public <E> Tabela<E> getPagina(Query queryPagina, Query queryQuantidadePaginas, final Integer quantidade, Integer pagina) {

		if (pagina == null) {			
			pagina = 0;
		}
		
		Tabela<E> resultado = new Tabela<E>();
		Number quantidadePaginas = (Number) queryQuantidadePaginas.getSingleResult();

		Integer total = quantidadePaginas.intValue() / quantidade;
		
		if ((quantidadePaginas.intValue() % quantidade) > 0 ) {
			
			total++;
		}
		
		resultado.setTotal(total);

		queryPagina.setFirstResult(quantidade * pagina);
		queryPagina.setMaxResults(quantidade);

		resultado.setTabela(queryPagina.getResultList()); 
			
		return resultado;
	}	
}
