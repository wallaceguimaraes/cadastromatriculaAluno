package br.com.sistema.main;

import br.com.sistema.util.HibernateUtil;

public class GeraTabela {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HibernateUtil.getSessionFactory();	
		
		System.out.println("Ola");
	}

}
