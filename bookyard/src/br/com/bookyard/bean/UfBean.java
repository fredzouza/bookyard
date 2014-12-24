package br.com.bookyard.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.bookyard.model.Uf;
import br.com.bookyard.service.UfService;

@ManagedBean
@RequestScoped
public class UfBean {

	private Uf uf = new Uf();
	UfService dao = new UfService();

	public void salvar(){
		String mensagem = null;
		
		if (uf.getId() == 0) {
			dao.createUf(uf);
			mensagem = "Registro inserido com sucesso!";
		} else {
			dao.updateUf(uf);
			mensagem = "Registro alterado com sucesso!";
		}
		limpa();
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, ""));
	}
	
	public List<Uf> lista(){
		return dao.findAllUf(uf);
	}
	
	public void deletar(){
		dao.deleteUf(uf);
		limpa();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluido com sucesso!", ""));
	}

	public void limpa(){
		uf = new Uf();
	}
	
	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}
	
}
