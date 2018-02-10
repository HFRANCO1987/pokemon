package com.novaxs.pokemon.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.novaxs.pokemon.model.MsgRetorno;
import com.novaxs.pokemon.model.Pokemon;
import com.novaxs.pokemon.model.PokemonTO;
import com.novaxs.pokemon.service.PokemonNeg;

@Path("/")
public class PokemonCtrl extends BaseCtrl<Pokemon> implements Serializable {

	private static final long serialVersionUID = -8993719345888040984L;

	@Inject
	private PokemonNeg pokemonNeg;
	
	/**
	 * Método GET "pokemon/NUMERO_DO_POKEMON/"
	 * 
	 * @param numeroDoPokemon
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/pokemon/{numero_do_pokemon}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPokemonPorNumero(@PathParam(value = "numero_do_pokemon") Long numeroDoPokemon)
			throws Exception {
		Pokemon pokemon = null;
		Integer status = Response.Status.OK.getStatusCode();
		MsgRetorno retorno = new MsgRetorno();
		try {
			pokemon = pokemonNeg.obterPokemonPorNumero(numeroDoPokemon);
			if (pokemon != null && pokemon.getNum() !=null 
					&& pokemon.getNum() > 0){
				retorno.getListPokemon().clear();
				retorno.getListPokemon().add(pokemon);
			}
		} catch (Exception e) {
			retorno.setMensagem("Houve uma falha ao obtert Pokemon:" + e.getMessage());
			retorno.setStatus(status);
			return Response.status(status).entity(retorno).build();
		}
		return Response.status(status).entity(new PokemonTO(15L)).build();
	}
	
	/**
	 * Método PUT "pokemon/NUMERO_DO_POKEMON/"
	 * 
	 * @param numeroPokemon
	 * @param pokemon
	 * @return
	 * @throws Exception
	 */
	@PUT
	@Path("/pokemon/{numero_do_pokemon}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizarPokemon(@PathParam(value = "numero_do_pokemon") Long numeroPokemon, Pokemon pokemon) throws Exception {
		Integer status = Response.Status.OK.getStatusCode();
		MsgRetorno retorno = new MsgRetorno();
		try {
			pokemonNeg.antesDePersisir(pokemon);
			pokemonNeg.alterar(pokemon);
			retorno.setMensagem("Pokemon atualizado com Sucesso");
		} catch (Exception e) {
			retorno.setMensagem("Houve uma falha ao atualizar Pokemon:" + e.getMessage());
			retorno.setStatus(status);
			return Response.status(status).entity(retorno).build();
		}
		retorno.setStatus(status);
		return Response.status(status).entity(retorno).build();
	}
	
	/**
	 * Método POST "pokemon"
	 * 
	 * @param pokemon
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path("/pokemon")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response gravarPokemon(Pokemon pokemon) throws Exception {
		Integer status = Response.Status.OK.getStatusCode();
		MsgRetorno retorno = new MsgRetorno();
		try {
			pokemonNeg.antesDePersisir(pokemon);
			pokemonNeg.incluir(pokemon);
			retorno.setMensagem("Pokemon gravado com Sucesso");
		} catch (Exception e) {
			retorno.setMensagem("Houve uma falha ao persisitr Pokemon:" + e.getMessage());
			retorno.setStatus(status);
			return Response.status(status).entity(retorno).build();
		}
		retorno.setStatus(status);
		return Response.status(status).entity(retorno).build();
	}
	
	/**
	 * "pokemon/NUMERO_DO_POKEMON/"
	 * 
	 * @param numeroDoPokemon
	 * @return
	 * @throws Exception
	 */
	@DELETE
	@Path("/pokemon/{numero_do_pokemon}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarPokemon(@PathParam(value = "numero_do_pokemon") Long numeroDoPokemon)
			throws Exception {
		Integer status = Response.Status.OK.getStatusCode();
		MsgRetorno retorno = new MsgRetorno();
		try {
			pokemonNeg.excluirPorId(numeroDoPokemon);
			retorno.setMensagem("Pokemon excluído com Sucesso");
		} catch (Exception e) {
			retorno.setMensagem("Houve uma falha ao excluir Pokemon:" + e.getMessage());
			retorno.setStatus(status);
			return Response.status(status).entity(retorno).build();
		}
		retorno.setStatus(status);
		return Response.status(status).entity(retorno).build();
	}

	/**
	 * "pokemons"
	 */
	@GET
	@Path("/pokemons")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterTodos() throws Exception {
		List<Pokemon> listPokemon = new ArrayList<Pokemon>();
		Integer status = Response.Status.OK.getStatusCode();
		MsgRetorno retorno = new MsgRetorno();
		try {
			listPokemon = pokemonNeg.obterTodos();
			if (listPokemon != null && !listPokemon.isEmpty()){
				retorno.setListPokemon(listPokemon);
			}
		} catch (Exception e) {
			retorno.setMensagem("Houve uma falha ao obtert todos Pokemon:" + e.getMessage());
			retorno.setStatus(status);
			return Response.status(status).entity(e.getMessage()).build();
		}
		return Response.status(status).entity(retorno).build();
	}
}
