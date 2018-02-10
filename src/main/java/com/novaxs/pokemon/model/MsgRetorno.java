package com.novaxs.pokemon.model;

import java.util.ArrayList;
import java.util.List;

public class MsgRetorno {

	private String mensagem;
	private Integer status;
	private List<Pokemon> listPokemon = new ArrayList<Pokemon>();
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<Pokemon> getListPokemon() {
		return listPokemon;
	}
	public void setListPokemon(List<Pokemon> listPokemon) {
		this.listPokemon = listPokemon;
	}
	
	
}
