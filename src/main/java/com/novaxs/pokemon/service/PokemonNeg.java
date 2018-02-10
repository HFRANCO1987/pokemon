package com.novaxs.pokemon.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import com.novaxs.pokemon.model.IListItemPokemon;
import com.novaxs.pokemon.model.Pokemon;
import com.novaxs.pokemon.repository.PokemonRepository;
import com.novaxs.pokemon.util.AplicacaoException;
import com.novaxs.pokemon.util.jpa.Transactional;

public class PokemonNeg extends GenericNegocio<Pokemon> implements Serializable {

	private static final long serialVersionUID = -5896407332735000453L;

	@Inject
	private PokemonRepository repository;

	public Pokemon obterPokemonPorNumero(Long numeroDoPokemon) {
		try {
			return repository.obterPorPropriedade("num", numeroDoPokemon.toString(), "=");
		} catch (AplicacaoException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Pokemon> obterTodos() throws Exception {
		return repository.obterTodos();
	}

	public void antesDePersisir(Pokemon pokemon) {
		preencheRelacionamentoBidirecional(pokemon, pokemon.getNext_evolution());
		preencheRelacionamentoBidirecional(pokemon, pokemon.getPrev_evolution());
	}

	private void preencheRelacionamentoBidirecional(Pokemon pokemon, Set<? extends IListItemPokemon> lista) {
		for (IListItemPokemon item : lista) {
			item.setPokemon(pokemon);
		}
	}

	@Transactional
	@Override
	public Pokemon incluir(Pokemon entidade) throws Exception {
		return repository.incluir(entidade);
	}

	@Transactional
	@Override
	public Pokemon alterar(Pokemon entidade) throws Exception {
		return repository.alterar(entidade);
	}

	@Transactional
	public void excluirPorId(Long numeroDoPokemon) throws AplicacaoException {
		repository.excluirPorId(numeroDoPokemon);
	}
}
