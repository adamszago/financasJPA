package br.com.financas.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

public class Teste {

	public static void main(String[] args) {
		Conta cc = new Conta();
		cc.setAgencia("4247");
		cc.setBanco("Santander");
		cc.setNumero("01072817-1");
		cc.setTitular("Adams Willians Alencar Zago");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(cc);
		em.getTransaction().commit();
		em.close();
		

	}

}
