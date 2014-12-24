package br.com.bookyard.service;

import java.util.List;

import br.com.bookyard.dao.TipoTelefoneDao;
import br.com.bookyard.model.TipoTelefone;

public class TipoTelefoneService {

	private TipoTelefoneDao tipoTelefoneDao = new TipoTelefoneDao();
	
	public void createTipoTelefone(TipoTelefone tipoTelefone){
		tipoTelefoneDao.create(tipoTelefone);
	}
	
	public List<TipoTelefone> findAllTipoTelefone(TipoTelefone tipoTelefone){
		return tipoTelefoneDao.findEntities(tipoTelefone);
	}
	
	public void updateTipoTelefone(TipoTelefone tipoTelefone){
		tipoTelefoneDao.update(tipoTelefone);
	}
	
	public void deleteTipoTelefone(TipoTelefone tipoTelefone){
		tipoTelefoneDao.delete(tipoTelefone);
	}
	
	public TipoTelefone findById(TipoTelefone tipoTelefone){
		return tipoTelefoneDao.findById(tipoTelefone);
	}
}
