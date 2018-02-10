package com.novaxs.pokemon.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "tab_pokemon")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = -1068802210721270244L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "num")
	private Long num;

	@Column(name = "name")
	private String name;

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "pokemon_type")
	private Set<String> type = new HashSet<String>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pokemon", cascade = CascadeType.ALL)
	private Set<NextEvolution> next_evolution = new HashSet<NextEvolution>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pokemon", cascade = CascadeType.ALL)
	private Set<PreEvolution> prev_evolution = new HashSet<PreEvolution>();

	public Pokemon() {
	}

	public Pokemon(Long numeroDoPokemon) {
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

	public Set<String> getType() {
		return type;
	}

	public void setType(Set<String> type) {
		this.type = type;
	}

	public Set<NextEvolution> getNext_evolution() {
		return next_evolution;
	}

	public void setNext_evolution(Set<NextEvolution> next_evolution) {
		this.next_evolution = next_evolution;
	}

	public Set<PreEvolution> getPrev_evolution() {
		return prev_evolution;
	}

	public void setPrev_evolution(Set<PreEvolution> prev_evolution) {
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
		Pokemon other = (Pokemon) obj;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		return true;
	}

	public PokemonTO pokemonTO() {
		PokemonTO pokemonTO = new PokemonTO();
		pokemonTO.setName(this.name);
		if (this.next_evolution != null && !this.next_evolution.isEmpty()) {
			pokemonTO.setNext_evolution(new ArrayList<>());
			for (NextEvolution nextEvolution : next_evolution) {
				pokemonTO.getNext_evolution().add(new EvolutionTO(nextEvolution));
			}
		}
		if (this.prev_evolution != null && !this.prev_evolution.isEmpty()) {
			pokemonTO.setPrev_evolution(new ArrayList<>());
			for (PreEvolution prevEvolution : prev_evolution) {
				pokemonTO.getPrev_evolution().add(new EvolutionTO(prevEvolution));
			}
		}
		if (this.type != null && !this.type.isEmpty()) {
			pokemonTO.setType(new ArrayList<>());
			for (String ty : type) {
				pokemonTO.getType().add(ty);
			}
		}
		pokemonTO.setNum(this.num);
		return pokemonTO;
	}

}
