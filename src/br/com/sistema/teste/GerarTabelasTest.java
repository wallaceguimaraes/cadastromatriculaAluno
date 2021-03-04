package br.com.sistema.teste;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.sistema.util.HibernateUtil;

public class GerarTabelasTest {

	
	//@BeforeClass
	@Test
	public void gerar() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
	
}
