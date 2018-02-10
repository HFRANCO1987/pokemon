package com.novaxs.pokemon.controller;

import javax.ws.rs.core.Response;

import com.novaxs.pokemon.model.BaseEntity;

public abstract class BaseCtrl<E extends BaseEntity<Long>> {

	private E objeto;

	public Response salvar(E entidade) throws Exception {
		throw new Exception("Metodo salvar não implementado");
	}

	public Response alterar(Long id) throws Exception {
		throw new Exception("Metodo alterar não implementado");
	}

	public Response excluir(Long id) throws Exception {
		throw new Exception("Metodo alterar não implementado");
	}

	public Response atualizar(E entidade) throws Exception {
		throw new Exception("Metodo salvar não implementado");
	}

	public Response obterTodos() throws Exception {
		throw new Exception("Metodo obterTodos não implementado");
	}

	public E getObjeto() {
		return objeto;
	}

	public void setObjeto(E objeto) {
		this.objeto = objeto;
	}

}
