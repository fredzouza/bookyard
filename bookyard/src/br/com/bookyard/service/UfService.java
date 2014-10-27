package br.com.bookyard.service;

import java.util.List;

import br.com.bookyard.dao.UfDao;
import br.com.bookyard.model.Uf;

public class UfService {

	private UfDao ufDao = new UfDao();
	
	public void createUf(Uf uf){
		ufDao.create(uf);
	}
	
	public List<Uf> findAllUf(Uf uf){
		return ufDao.readAll(uf);
	}
	
	public void updateUf(Uf uf){
		ufDao.update(uf);
	}
	
	public void deleteUf(Uf uf){
		ufDao.delete(uf);
	}
	
	public Uf findById(Uf uf){
		return ufDao.findById(uf);
	}
}
