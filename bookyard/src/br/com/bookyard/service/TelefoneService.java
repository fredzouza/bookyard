package br.com.bookyard.service;

import java.util.List;

import br.com.bookyard.dao.TelefoneDao;
import br.com.bookyard.model.Telefone;

public class TelefoneService {

	private TelefoneDao telefoneDao = new TelefoneDao();
	
	public void createTelefone(Telefone telefone){
		telefoneDao.create(telefone);
	}
	
	public List<Telefone> findAllTelefone(Telefone telefone){
		return telefoneDao.readAll(telefone);
	}
	
	public void updateTelefone(Telefone telefone){
		telefoneDao.update(telefone);
	}
	
	public void deleteTelefone(Telefone telefone){
		telefoneDao.delete(telefone);
	}
	
	public Telefone findById(Telefone telefone){
		return telefoneDao.findById(telefone);
	}
}
