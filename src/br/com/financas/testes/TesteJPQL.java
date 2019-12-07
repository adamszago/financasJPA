package br.com.financas.testes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(7);
		
		String consulta = "SELECT m from Movimentacao m where m.conta = :pConta";
		Query query = em.createQuery(consulta);
		query.setParameter("pConta", conta);
		
		List<Movimentacao> movimentacoes = new ArrayList<>();
		movimentacoes = query.getResultList();
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println(movimentacao.getDescricao());
		}
		
		em.getTransaction().commit();
		em.close();
	}
}
