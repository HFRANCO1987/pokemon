package com.novaxs.pokemon.model;

import java.io.Serializable;
import java.util.List;

public class PokemonTO implements Serializable {

	private static final long serialVersionUID = 8139147337165227533L;

	private Long num;
	private String name;
	private List<String> type;
	private List<EvolutionTO> next_evolution;
	private List<EvolutionTO> prev_evolution;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		return result;
	}

	public List<EvolutionTO> getNext_evolution() {
		return next_evolution;
	}

	public void setNext_evolution(List<EvolutionTO> next_evolution) {
		this.next_evolution = next_evolution;
	}

	public List<EvolutionTO> getPrev_evolution() {
		return prev_evolution;
	}

	public void setPrev_evolution(List<EvolutionTO> prev_evolution) {
		this.prev_evolution = prev_evolution;
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
