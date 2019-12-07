package br.com.financas.testes;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = manager.find(Conta.class, 1);
		
		System.out.println(conta);
		
		manager.getTransaction().commit();
		manager.close();

	}

}
