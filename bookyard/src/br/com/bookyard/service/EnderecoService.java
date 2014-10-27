package br.com.bookyard.service;

import java.util.List;

import br.com.bookyard.dao.EnderecoDao;
import br.com.bookyard.model.Endereco;

public class EnderecoService {

	private EnderecoDao enderecoDao = new EnderecoDao();
	
	public void createEndereco(Endereco endereco){
		enderecoDao.create(endereco);
	}
	
	public List<Endereco> findAllEndereco(Endereco endereco){
		return enderecoDao.readAll(endereco);
	}
	
	public void updateEndereco(Endereco endereco){
		enderecoDao.update(endereco);
	}
	
	public void deleteEndereco(Endereco endereco){
		enderecoDao.delete(endereco);
	}
	
	public Endereco findById(Endereco endereco){
		return enderecoDao.findById(endereco);
	}
}
