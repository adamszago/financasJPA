package br.com.financas.testes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.financas.dao.MovimentacaoDAO;
import br.com.financas.modelo.Conta;
import br.com.financas.modelo.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TesteMovimentacaoGroup {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);

		
		
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		List<Double> media = dao .getMovimentacoesPorTipoEConta(TipoMovimentacao.SAIDA, conta);
		System.out.println("A m�dia de 26 �: " + media.get(0));
		System.out.println("A m�dia de 27 �: " + media.get(1));
		
		
		em.getTransaction().commit();
		em.close();
	}
}
