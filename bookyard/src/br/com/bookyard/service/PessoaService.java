package br.com.bookyard.service;

import java.util.List;

import br.com.bookyard.dao.PessoaDao;
import br.com.bookyard.model.Pessoa;

public class PessoaService {

	private PessoaDao pessoaDao = new PessoaDao();
	
	public void createPessoa(Pessoa pessoa){
		pessoaDao.create(pessoa);
	}
	
	public List<Pessoa> findAllPessoa(Pessoa pessoa){
		return pessoaDao.findEntities(pessoa);
	}
	
	public void updatePessoa(Pessoa pessoa){
		pessoaDao.update(pessoa);
	}
	
	public void deletePessoa(Pessoa pessoa){
		pessoaDao.delete(pessoa);
	}
	
	public Pessoa findById(Pessoa pessoa){
		return pessoaDao.findById(pessoa);
	}
}
