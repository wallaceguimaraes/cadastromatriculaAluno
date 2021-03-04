package br.com.sistema.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistema.domain.Aula;
import br.com.sistema.domain.Turma;
import br.com.sistema.util.FacesUtil;
import br.com.sistema.util.HibernateUtil;

public class AulaDao {

	
public void salvar(Aula aula) {
		
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			
			//FacesUtil.adicionarMsgInfo(" "+aula);
			sessao.save(aula);
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
	public List<Aula> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Aula> aulas = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Aula.listar");
			aulas = consulta.list();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return aulas;
	}	
	

	public Aula buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Aula aula = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Aula.buscarPorCodigo");
			consulta.setLong("idAula", codigo);
			aula = (Aula) consulta.uniqueResult();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return aula;
	}
	
	
	
	
	public List<Aula> buscarPorChave(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Aula> aulas = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Aula.buscarPorChave");
			consulta.setLong("turma", codigo);
			aulas = consulta.list();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return aulas;
	}
	
	
	
	
	public void excluir(Aula aula) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(aula);
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
	
	public void editar(Aula aula) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(aula);
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
