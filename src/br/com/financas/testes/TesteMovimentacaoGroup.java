package br.com.financas.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TesteMovimentacaoGroup {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);

		String query = "Select avg(m.valor) from Movimentacao m where m.conta = :pConta "
				+ "and m.tipo = :pTipo "
				+ "group by day(m.data), month(m.data), year(m.data)";
		
		TypedQuery<Double> jpql = em.createQuery(query, Double.class);
		jpql.setParameter("pConta", conta);
		jpql.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> media = (List<Double>)jpql.getResultList();
		System.out.println("A média de 26 é: " + media.get(0));
		System.out.println("A média de 27 é: " + media.get(1));
		
		
		em.getTransaction().commit();
		em.close();
	}
}
