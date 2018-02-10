package com.novaxs.pokemon.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {
	
	private EntityManagerFactory factoryMysql;
	
	public EntityManagerProducer() {
		factoryMysql = Persistence.createEntityManagerFactory("bdmysql");
	}
	
	@RequestScoped
	@Produces
	@Default
	public EntityManager createEntityManagerMysql() {
		return factoryMysql.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager manager) {
		if (manager.isOpen()) {
            manager.close();
        }
	}
	
}