package com.novaxs.pokemon.service;

import java.io.Serializable;
import java.util.List;

import com.novaxs.pokemon.model.BaseEntity;

public interface IGenericNegocio<E extends BaseEntity<Long>> extends Serializable {

	public E incluir(E entidade) throws Exception;

	public E alterar(E entidade) throws Exception;

	public void excluirPorId(E id) throws Exception;

	public E obterPorId(E id) throws Exception;

	public List<E> obterTodos() throws Exception;

	public E obterPorPropriedade(String propNome, String valor, String operador) throws Exception;

}
