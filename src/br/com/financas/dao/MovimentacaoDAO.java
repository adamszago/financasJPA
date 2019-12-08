package br.com.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.TipoMovimentacao;

public class MovimentacaoDAO {

	private EntityManager em;

	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}

	public List<Double> getMovimentacoesPorTipoEConta(TipoMovimentacao saida, Conta conta) {
		String query = "Select avg(m.valor) from Movimentacao m where m.conta = :pConta " + "and m.tipo = :pTipo "
				+ "group by day(m.data), month(m.data), year(m.data)";

		TypedQuery<Double> jpql = em.createQuery(query, Double.class);
		jpql.setParameter("pConta", conta);
		jpql.setParameter("pTipo", TipoMovimentacao.SAIDA);

		return jpql.getResultList();
	}

}
