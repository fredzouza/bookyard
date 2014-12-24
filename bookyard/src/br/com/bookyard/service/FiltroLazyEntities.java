package br.com.bookyard.service;

import java.io.Serializable;

public class FiltroLazyEntities implements Serializable {

	private static final long serialVersionUID = 1L;

	private int primeiroRegistro;
	private int quantidadeRegistro;
	private String ordenacao;
	private boolean ascendente;

	public int getPrimeiroRegistro() {
		return primeiroRegistro;
	}

	public void setPrimeiroRegistro(int primeiroRegistro) {
		this.primeiroRegistro = primeiroRegistro;
	}

	public int getQuantidadeRegistros() {
		return quantidadeRegistro;
	}

	public void setQuantidadeRegistros(int quantidadeRegistros) {
		this.quantidadeRegistro = quantidadeRegistros;
	}

	public String getOrdenacao() {
		return ordenacao;
	}

	public void setOrdenacao(String ordenacao) {
		this.ordenacao = ordenacao;
	}

	public boolean isAscendente() {
		return ascendente;
	}

	public void setAscendente(boolean ascendente) {
		this.ascendente = ascendente;
	}

}
