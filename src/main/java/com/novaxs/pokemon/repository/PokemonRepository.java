package com.novaxs.pokemon.repository;

import com.novaxs.pokemon.model.Pokemon;

public class PokemonRepository extends GenericoDaoImp<Pokemon, Long> {

	private static final long serialVersionUID = 8515459621978400158L;

	// @SuppressWarnings("unchecked")
	// public List<Pokemon> obterPokemonPor(Long idVendedor) throws
	// AplicacaoException {
	// List<Pessoa> listaClientes = new ArrayList<Pessoa>();
	// try {
	// //ADMIN - MARCOS - VENDAS
	// if (idVendedor.compareTo(new Long(54))==0){
	// StringBuilder hql = new StringBuilder("select distinct p from Pessoa p
	// where p.codEmpresa = 2"
	// + " order by p.razaoSocial asc");
	// listaClientes = getEntityManager().createQuery(hql.toString())
	// .getResultList();
	// }else{
	// StringBuilder hql = new StringBuilder("select distinct p from Pessoa p "
	// + " where p.codEmpresa = 2 and p.vendedor.id = :idVendedor"
	// + " order by p.razaoSocial asc");
	// listaClientes = getEntityManager().createQuery(hql.toString())
	// .setParameter("idVendedor", idVendedor)
	// .getResultList();
	// }
	// } catch (NoResultException e) {
	// e.printStackTrace();
	// throw new AplicacaoException(e);
	// }
	// return listaClientes;
	// }
	//
	// @SuppressWarnings("unchecked")
	// public List<VContasReceb> listarContasReceberPorCliente(Integer
	// idCliente) throws AplicacaoException {
	// List<VContasReceb> listaVContasReceb = new ArrayList<VContasReceb>();
	// try {
	// StringBuilder hql = new StringBuilder("select distinct p from
	// VContasReceb p "
	// + " where p.codEmpresa = 2 and status = 'A' and p.codCliente = :idCliente
	// order by 1 asc");
	//
	// listaVContasReceb = getEntityManager().createQuery(hql.toString())
	// .setParameter("idCliente", idCliente)
	// .getResultList();
	//
	// } catch (NoResultException e) {
	// e.printStackTrace();
	// throw new AplicacaoException(e);
	// }
	// return listaVContasReceb;
	// }
	//
	// @SuppressWarnings("unchecked")
	// public List<VConsultaEntrada> listarAbatesPorDia(Date data) throws
	// AplicacaoException {
	// List<VConsultaEntrada> listaVConsultaEntrada = new
	// ArrayList<VConsultaEntrada>();
	// try {
	// StringBuilder hql = new StringBuilder("select distinct p from
	// VConsultaEntrada p "
	// + " where p.dataAbt = :data order by 1 asc");
	//
	// listaVConsultaEntrada = getEntityManager().createQuery(hql.toString())
	// .setParameter("data", DateUtil.formatarData(data, "dd/MM/yyyy"))
	// .getResultList();
	//
	// } catch (NoResultException e) {
	// e.printStackTrace();
	// throw new AplicacaoException(e);
	// }
	// return listaVConsultaEntrada;
	// }
}