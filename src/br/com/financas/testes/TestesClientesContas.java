package br.com.financas.testes;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Cliente;
import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

public class TestesClientesContas {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("Adams Willians Alencar Zago");
		cliente.setEndereco("Ptro. Osmar tavares, 1682 apto 202");
		cliente.setProfissao("Gerente de Relacionamento");
		
		Conta conta = new Conta();
		conta.setId(7);
		cliente.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
	}
}
