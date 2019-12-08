package br.com.financas.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

public class TesteTodasMovimentacoesContas {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		String query = "Select distinct c from Conta c left join fetch c.movimentacoes";
		Query jpql = em.createQuery(query);
		List<Conta> contas = jpql.getResultList();
		
		for (Conta conta : contas) {
			System.out.println(conta.getTitular());
			System.out.println("Movimentações : ");
			System.out.println(conta.getMovimentacoes());
		}
		
		

		em.getTransaction().commit();
		em.close();
	}
}
