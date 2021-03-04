package br.com.sistema.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistema.domain.Cadastro;
import br.com.sistema.domain.Matricula;
import br.com.sistema.util.HibernateUtil;

public class MatriculaDao {

public void salvar(Matricula matricula) {
		
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(matricula);
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
	public List<Matricula> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Matricula> matriculas = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Matricula.listar");
			matriculas = consulta.list();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return matriculas;
	}	
	

	public Matricula buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Matricula matricula = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Matricula.buscarPorCodigo");
			consulta.setLong("idMatricula", codigo);
			matricula = (Matricula) consulta.uniqueResult();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return matricula;
	}
	

	public Matricula buscarPorAlunoTurma(Long codigo, Long codig) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Matricula matricula = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Matricula.buscarPorAlunoTurma");
			consulta.setLong("aluno", codigo);
			consulta.setLong("turma", codig);
			matricula = (Matricula) consulta.uniqueResult();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return matricula;
	}
	

	
	
	public Matricula buscarPorAlunoEnsino(Long codigo, Long codig) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Matricula matricula = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Matricula.buscarPorAlunoEnsino");
			consulta.setLong("aluno", codigo);
			consulta.setLong("ensino", codig);
			matricula = (Matricula) consulta.uniqueResult();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return matricula;
	}
	
	
	
	
	
	public List<Matricula> buscarPorChave(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Matricula> matriculas = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Matricula.buscarPorChave");
			consulta.setLong("aluno", codigo);
			matriculas = consulta.list();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return matriculas;
	}
	

	
	public List<Matricula> buscarPorTurma(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Matricula> matriculas = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Matricula.buscarPorTurma");
			consulta.setLong("turma", codigo);
			matriculas = consulta.list();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return matriculas;
	}
	

	
	
	
	public List<Matricula> buscarPorEnsino(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Matricula> matriculas = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Matricula.buscarPorEnsino");
			consulta.setLong("ensino", codigo);
			matriculas = consulta.list();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return matriculas;
	}
	
	
	
	
	public void excluir(Matricula matricula) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(matricula);
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
	
	public void editar(Matricula matricula) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(matricula);
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
	
	
	public Matricula buscarUltimo() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Matricula matricula = null;

		try {
			Query consulta = sessao.getNamedQuery("Matricula.buscarUltimo");
			consulta.setMaxResults(1);
			
			matricula = (Matricula)consulta.uniqueResult();
			
			if( matricula == null) {
				matricula = null;
			}
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return matricula;
		
	}
	
}
