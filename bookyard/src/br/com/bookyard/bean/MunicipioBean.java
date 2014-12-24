package br.com.bookyard.bean;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.bookyard.model.Municipio;
import br.com.bookyard.service.FiltroLazyEntities;
import br.com.bookyard.service.MunicipioService;
import br.com.bookyard.service.UfService;

@ManagedBean
@RequestScoped
public class MunicipioBean {

	private LazyDataModel<Municipio> lazyMunicipio;
	private FiltroLazyEntities filtro = new FiltroLazyEntities();
	private Municipio municipio = new Municipio();
	private MunicipioService dao = new MunicipioService();
	
	public MunicipioBean(){
		lazyMunicipio = new LazyDataModel<Municipio>() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public List<Municipio> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, String> filters) {

				filtro.setPrimeiroRegistro(first);
				filtro.setQuantidadeRegistros(pageSize);
				filtro.setAscendente(SortOrder.ASCENDING.equals(sortOrder));
				filtro.setOrdenacao(sortField);
				
				setRowCount(dao.findEntitiesLzyTotal(municipio).intValue());
				return dao.findEntitiesLazy(filtro, municipio);
			}
		};
	}
	
	public void salvar(){
		String mensagem = null;
		UfService ufService = new UfService();

		if (municipio.getId() == 0) {
			municipio.setId(null);
			municipio.setUf(ufService.findById(municipio.getUf()));
			
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

	public void limpar(){
		municipio = new Municipio();
	}
	
	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public FiltroLazyEntities getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroLazyEntities filtro) {
		this.filtro = filtro;
	}

	public LazyDataModel<Municipio> getLazyMunicipio() {
		return lazyMunicipio;
	}

	public void setLazyMunicipio(LazyDataModel<Municipio> lazyMunicipio) {
		this.lazyMunicipio = lazyMunicipio;
	}

}
