package br.com.sistema.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistema.domain.Aluno;
import br.com.sistema.domain.Atividade;
import br.com.sistema.domain.Professor;
import br.com.sistema.domain.Usuario;
import br.com.sistema.util.HibernateUtil;

public class AtividadeDao {
	
	
public void salvar(Atividade atividade) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(atividade);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
		
		
		

	}
	
@SuppressWarnings("unchecked")
public List<Atividade> listar() {
	Session sessao = HibernateUtil.getSessionFactory().openSession();
	List<Atividade> atividades = null;
	
	try {
		Query consulta = sessao.getNamedQuery("Atividade.listar");
		atividades = consulta.list();
		
	} catch (RuntimeException ex) {			
		throw ex;
	} finally {
		sessao.close();
	}
	return atividades;
}	
	



public List<Atividade> buscarPorCodigo(Long codigo) {
	Session sessao = HibernateUtil.getSessionFactory().openSession();
	List<Atividade> atividades = null;

	try {
		Query consulta = sessao.getNamedQuery("Atividade.buscarPorCodigo");
		consulta.setLong("idUsuario", codigo);// codig esquerda é o:codigo e o direita é o recebido do metodo

		atividades = consulta.list();

	} catch (RuntimeException ex) {
		throw ex;
	} finally {
		sessao.close();
	}
	return atividades;
}



public void excluir(Atividade atividade) {
	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;

	try {
		transacao = sessao.beginTransaction();
		sessao.delete(atividade);
		transacao.commit();
	} catch (RuntimeException ex) {
		if (transacao != null) {
			transacao.rollback();
		}
		throw ex;
	} finally {
		sessao.close();
	}

}



}
