package br.com.financas.testes;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TesteRelacionamento {

	public static void main(String[] args) {

		Movimentacao movimentacao1 = new Movimentacao();
		Conta conta = new Conta();
		
		conta.setAgencia("0102");
		conta.setBanco("ITAU");
		conta.setNumero("01072817-1");
		conta.setTitular("Adams Willians Alencar Zago");

		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("Depósito de convite antecipado");
		movimentacao1.setValor(new BigDecimal("5651.10"));
		movimentacao1.setTipo(TipoMovimentacao.ENTRADA);
		movimentacao1.setConta(conta);
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(conta);
		manager.persist(movimentacao1);
		
		manager.getTransaction().commit();
		manager.close();

	}

}
