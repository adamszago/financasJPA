package br.com.financas.testes;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Categoria;
import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TestesMovimentacoesComCategorias {

	public static void main(String[] args) {
		
		Categoria cat1 = new Categoria("Viagem");
		Categoria cat2 = new Categoria("Negócios");
		Conta conta = new Conta();
		conta.setId(2);
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("Viagem São Paulo");
		movimentacao1.setValor(new BigDecimal("100.00"));
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setCategorias(Arrays.asList(cat1, cat2));
		movimentacao1.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Viagem RJ");
		movimentacao2.setValor(new BigDecimal("300.00"));
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setCategorias(Arrays.asList(cat1, cat2));
		movimentacao1.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cat1);
		em.persist(cat2);
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		em.getTransaction().commit();
		em.close();
	}
}
