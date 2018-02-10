package com.novaxs.pokemon.model;

import java.io.Serializable;

public class EvolutionTO implements Serializable {

	private static final long serialVersionUID = 4083035318497907427L;

	private Long id;
	private Long num;
	private String name;
	private PokemonTO pokemon;

	public EvolutionTO() {
	}

	public EvolutionTO(NextEvolution nextEvolution) {
		this.id = nextEvolution.getId();
		this.num = nextEvolution.getNum();
		this.name = nextEvolution.getName();
		this.pokemon = new PokemonTO(nextEvolution.getPokemon().getNum());
	}

	public EvolutionTO(PreEvolution prevEvolution) {
		this.id = prevEvolution.getId();
		this.num = prevEvolution.getNum();
		this.name = prevEvolution.getName();
		this.pokemon = new PokemonTO(prevEvolution.getPokemon().getNum());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public PokemonTO getPokemon() {
		return pokemon;
	}

	public void setPokemon(PokemonTO pokemon) {
		this.pokemon = pokemon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		EvolutionTO other = (EvolutionTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		return true;
	}

}
