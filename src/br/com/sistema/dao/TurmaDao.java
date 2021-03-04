package br.com.sistema.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistema.domain.Cadastro;
import br.com.sistema.domain.Matricula;
import br.com.sistema.domain.Turma;
import br.com.sistema.util.FacesUtil;
import br.com.sistema.util.HibernateUtil;

public class TurmaDao {

	
	public void salvar(Turma turma) {
		
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			
			

			sessao.save(turma);
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
	public List<Turma> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Turma> turmas = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Turma.listar");
			turmas = consulta.list();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return turmas;
	}	
	

	public Turma buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Turma turma = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Turma.buscarPorCodigo");
			consulta.setLong("idTurma", codigo);
			turma = (Turma) consulta.uniqueResult();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return turma;
	}
	
	
	
	
	public List<Turma> buscarPorChave(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Turma> turmas = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Turma.buscarPorChave");
			consulta.setLong("professor", codigo);
			turmas = consulta.list();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return turmas;
	}
	
	
	
	
public List<Turma> buscarPorDisciplina(Long idCursoModulo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Turma> turmas = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Turma.buscarPorDisciplina");
			consulta.setLong("curso", idCursoModulo);
			turmas = consulta.list();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return turmas;
	}
	
	
	

	public Turma buscarUltimo() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Turma turma = null;

		try {
			Query consulta = sessao.getNamedQuery("Turma.buscarUltimo");
			consulta.setMaxResults(1);
			
			turma = (Turma)consulta.uniqueResult();
			
			if( turma == null) {
				turma = null;
			}
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return turma;
		
	}
	
	
	
	
	public void excluir(Turma turma) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(turma);
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
	
	public void editar(Turma turma) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(turma);
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
