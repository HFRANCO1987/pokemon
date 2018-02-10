package com.novaxs.pokemon.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.ConstraintViolationException;

import com.novaxs.pokemon.util.AplicacaoException;

public class GenericoDaoImp<E, ID extends Serializable> implements GenericoDaoUI<E, ID> {

	private static final long serialVersionUID = -1709958876763361756L;

	private Class<E> classeEntidade;

	private Log log = LogFactory.getLog(this.getClass());

	@Inject
	@Default
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	public GenericoDaoImp() {
		this.classeEntidade = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public E alterar(E entidade) throws AplicacaoException {
		try {
			E e = em.merge(entidade);
			em.flush();
			return e;
		} catch (EntityExistsException e) {
			throw new AplicacaoException("NÃ£o foi possÃ­vel confirmar o registro. Provavelmente estÃ¡ duplicado", e);
		} catch (RuntimeException e) {
			log.error("erro ao alterar:" + entidade.toString() + " - " + e.getMessage(), e);
			throw new AplicacaoException(e.getMessage(), e);
		}
	}

	public void excluirPorId(Object id) throws AplicacaoException {
		try {
			E entidade = em.find(classeEntidade, id);
			em.remove(entidade);
			em.flush();
		} catch (EntityExistsException e) {
			throw new AplicacaoException("Não foi possível excluir o registro. Provavelmente está sendo utilizado");
		} catch (PersistenceException e) {
			if (e.getCause() instanceof ConstraintViolationException) {
				throw new AplicacaoException(
						"Este registro não pode ser excluído pois está referenciado em outras partes do sistema.", e);
			} else {
				throw new AplicacaoException(e.getMessage(), e);
			}
		} catch (RuntimeException e) {
			log.error("erro ao excluir:" + classeEntidade + " com id:" + id + " - " + e.getMessage(), e);
			throw new AplicacaoException(e.getMessage(), e);
		}
	}

	public E incluir(E entidade) throws AplicacaoException {
		try {
			if (!em.contains(entidade))
				entidade = em.merge(entidade);
			em.persist(entidade);
			return entidade;
		} catch (EntityExistsException e) {
			throw new AplicacaoException("Não foi possível confirmar o registro. Provavelmente estão duplicado", e);
		} catch (RuntimeException e) {
			log.error("erro ao incluir: " + e.getMessage() + " - " + entidade.toString(), e);
			throw new AplicacaoException(e.getMessage(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<E> obterTodos() throws AplicacaoException {
		try {
			Query query = em.createQuery("select e from " + classeEntidade.getSimpleName() + " e");
			return query.getResultList();
		} catch (Exception e) {
			log.error("erro ao listar " + e.getMessage(), e);
			throw new AplicacaoException(e.getMessage(), e);
		}
	}

	public void flush() {
		em.flush();
	}

	public void clear() {
		em.clear();
	}

	public List<E> alterar(List<E> entidades) throws AplicacaoException {
		List<E> resultado = new ArrayList<E>();
		for (E e : entidades) {
			resultado.add(em.merge(e));
		}
		em.flush();
		return resultado;
	}

	public EntityManager getEntityManager() {
		return em;
	}

	public E obterPorId(ID id) throws AplicacaoException {
		try {
			E obj = null;
			obj = (E) getEntityManager().find(classeEntidade, id);
			return obj;
		} catch (Exception e) {
			throw new AplicacaoException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<E> obterTodos(String propOrdenacao, String tipoOrdenacao) throws AplicacaoException {
		try {
			List<E> lista = new ArrayList<E>();
			Query query = getEntityManager().createQuery("select x from " + classeEntidade.getSimpleName()
					+ " x order by x." + propOrdenacao + " " + tipoOrdenacao);
			lista = query.getResultList();
			return lista;
		} catch (Exception e) {
			throw new AplicacaoException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public E obterPorPropriedade(String propNome, String valor, String operador) throws AplicacaoException {
		try {
			E lista = null;

			Query query = null;

			query = getEntityManager().createQuery("select x from " + classeEntidade.getSimpleName() + " x where x."
					+ propNome + operador + "'" + valor + "'");

			lista = (E) query.getSingleResult();
			return lista;
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new AplicacaoException(e);
		}
	}
}
