package com.novaxs.pokemon.service;

import java.util.List;

import com.novaxs.pokemon.model.BaseEntity;

public abstract class GenericNegocio<E extends BaseEntity<Long>> implements IGenericNegocio<E> {

	private static final long serialVersionUID = -7302513520197515965L;

	@Override
	public E incluir(E entidade) throws Exception {
		throw new Exception("Metódo incluir não implementado!");
	}

	@Override
	public E alterar(E entidade) throws Exception {
		throw new Exception("Metódo alterar não implementado!");
	}

	@Override
	public void excluirPorId(E id) throws Exception {
		throw new Exception("Metódo excluirPorId não implementado!");
	}

	@Override
	public E obterPorId(E id) throws Exception {
		throw new Exception("Metódo obterPorId não implementado!");
	}

	@Override
	public E obterPorPropriedade(String propNome, String valor, String operador) throws Exception {
		throw new Exception("Metódo obterPorPropriedade não implementado!");
	}

	@Override
	public List<E> obterTodos() throws Exception {
		throw new Exception("Metódo obterTodos não implementado!");
	}
}
