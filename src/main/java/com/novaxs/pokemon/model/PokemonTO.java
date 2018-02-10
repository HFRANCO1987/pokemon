package com.novaxs.pokemon.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PokemonTO implements Serializable {

	private static final long serialVersionUID = 8139147337165227533L;

	private Long num;
	private String name;
	private List<String> type = new ArrayList<String>();
	private List<NextEvolution> next_evolution = new ArrayList<NextEvolution>();
	private List<PreEvolution> prev_evolution = new ArrayList<PreEvolution>();

	public PokemonTO() {
	}

	public PokemonTO(Long numeroDoPokemon) {
		this.num = numeroDoPokemon;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public List<NextEvolution> getNext_evolution() {
		return next_evolution;
	}

	public void setNext_evolution(List<NextEvolution> next_evolution) {
		this.next_evolution = next_evolution;
	}

	public List<PreEvolution> getPrev_evolution() {
		return prev_evolution;
	}

	public void setPrev_evolution(List<PreEvolution> prev_evolution) {
		this.prev_evolution = prev_evolution;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PokemonTO other = (PokemonTO) obj;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		return true;
	}

}
