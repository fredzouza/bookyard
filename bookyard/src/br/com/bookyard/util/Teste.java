package br.com.bookyard.util;

import br.com.bookyard.model.Pessoa;
import br.com.bookyard.model.Telefone;
import br.com.bookyard.model.TipoTelefone;
import br.com.bookyard.service.PessoaService;
import br.com.bookyard.service.TelefoneService;
import br.com.bookyard.service.TipoTelefoneService;

public class Teste {

	public static void main(String[] args) {
		
		TelefoneService telefoneService = new TelefoneService();
		TipoTelefoneService tipoTelefoneService= new TipoTelefoneService();
		PessoaService pessoaService = new PessoaService();
		
		TipoTelefone tipoTelefone = new TipoTelefone(); 
		Telefone t = new Telefone();
		Pessoa pessoa = new Pessoa();
		
		tipoTelefone.setId(1l);
		tipoTelefone = tipoTelefoneService.findById(tipoTelefone);
		
		
		t.setDdd(85);
		t.setNumero(12345678);
	}
}
