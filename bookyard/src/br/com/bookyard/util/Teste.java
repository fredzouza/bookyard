package br.com.bookyard.util;

import br.com.bookyard.model.Endereco;
import br.com.bookyard.model.Municipio;
import br.com.bookyard.model.Telefone;
import br.com.bookyard.model.TipoTelefone;
import br.com.bookyard.model.Uf;
import br.com.bookyard.service.EnderecoService;
import br.com.bookyard.service.MunicipioService;
import br.com.bookyard.service.TelefoneService;
import br.com.bookyard.service.TipoTelefoneService;
import br.com.bookyard.service.UfService;

public class Teste {

	public static void main(String[] args) {
		Teste teste = new Teste();
//		teste.addTelefone();
		teste.addMunicipio();
//		teste.addEndereco();
		
	}

	public void addTelefone(){
		TelefoneService telefoneService = new TelefoneService();
		TipoTelefoneService tipoTelefoneService= new TipoTelefoneService();
		
		TipoTelefone tipoTelefone = new TipoTelefone(); 
		Telefone t = new Telefone();
		
		tipoTelefone.setId(1l);
		tipoTelefone = tipoTelefoneService.findById(tipoTelefone);
		
		
		t.setDdd(85);
		t.setNumero(12345678);
		t.setTipoTelefone(tipoTelefone);
		telefoneService.createTelefone(t);
	}

	public void addMunicipio(){
		Municipio m = new Municipio();
		MunicipioService ms = new MunicipioService();

		Uf u = new Uf();
		UfService us = new UfService();
		
		u.setId(1l);
		u = us.findById(u);
		
		m.setDescricao("Outro");
		m.setUf(u);
		
		ms.createMunicipio(m);
	}
	
	public void addEndereco(){
		Endereco e = new Endereco();
		EnderecoService es = new EnderecoService();
		
		Municipio m = new Municipio();
		MunicipioService ms = new MunicipioService();

		m.setId(16l);
		m = ms.findById(m);
		
		e.setLogradouro("endereco");
		e.setNumero("123");
		e.setMunicipio(m);
		
		es.createEndereco(e);
	}
	
	public void addPessoa(){
//		Pessoa
	}
}
