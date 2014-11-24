package br.com.bookyard.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.bookyard.model.Municipio;
import br.com.bookyard.model.Uf;
import br.com.bookyard.service.MunicipioService;
import br.com.bookyard.service.UfService;

@ManagedBean
@RequestScoped
public class MunicipioBean {

	private Municipio municipio = new Municipio();
	private MunicipioService dao = new MunicipioService();
	private Uf uf = new Uf();
	
	public void limpar(){
		municipio = new Municipio();
		uf = new Uf();
	}
	
	public void salvar(){
		String mensagem = null;
		UfService ufService = new UfService();

		if (municipio.getId() == 0) {
			municipio.setId(null);
			municipio.setUf(ufService.findById(uf));
			
			dao.createMunicipio(municipio);
			
			mensagem = "Municipio adicionado com sucesso!";
		} else {
			dao.updateMunicipio(municipio);
			mensagem = "Municipio alterado com sucesso!";
		}
		
		limpar();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, ""));
	}
	
	public List<Municipio> listar() {
		return dao.findAllMunicipio(municipio);
	}
	
	public void delete() {
		dao.deleteMunicipio(municipio);
		limpar();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Municipio excluido com sucesso!", ""));
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

}
