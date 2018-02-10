package com.novaxs.pokemon.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import com.novaxs.pokemon.util.AplicacaoException;

public interface GenericoDaoUI<E, ID extends Serializable> extends Serializable {

	public E incluir(E entidade) throws AplicacaoException;

	public List<E> alterar(List<E> entidades) throws AplicacaoException;

	public E alterar(E entidade) throws AplicacaoException;

	public void excluirPorId(Object id) throws AplicacaoException;

	public void flush();

	public void clear();

	public EntityManager getEntityManager();

	public E obterPorId(ID id) throws AplicacaoException;

	public List<E> obterTodos() throws AplicacaoException;

	public E obterPorPropriedade(String propNome, String valor, String operador) throws AplicacaoException;

}
