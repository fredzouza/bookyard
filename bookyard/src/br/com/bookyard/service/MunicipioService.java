package br.com.bookyard.service;

import java.util.List;

import br.com.bookyard.dao.MunicipioDao;
import br.com.bookyard.model.Municipio;

public class MunicipioService {

	private MunicipioDao municipioDao = new MunicipioDao();
	
	public void createMunicipio(Municipio municipio){
		municipioDao.create(municipio);
	}
	
	public List<Municipio> findAllMunicipio(Municipio municipio){
		return municipioDao.readAll(municipio);
	}
	
	public void updateMunicipio(Municipio municipio){
		municipioDao.update(municipio);
	}
	
	public void deleteMunicipio(Municipio municipio){
		municipioDao.delete(municipio);
	}
	
	public Municipio findById(Municipio municipio){
		return municipioDao.findById(municipio);
	}
}
