package br.com.sistema.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistema.domain.Aluno;
import br.com.sistema.domain.Cadastro;
import br.com.sistema.util.HibernateUtil;

public class AlunoDao {
	
	
public void salvar(Aluno aluno) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(aluno);
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
	public List<Aluno> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Aluno> alunos = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Aluno.listar");
			alunos = consulta.list();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return alunos;
	}	
	

	public Aluno buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Aluno aluno = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Aluno.buscarPorCodigo");
			consulta.setLong("idAluno", codigo);
			aluno = (Aluno) consulta.uniqueResult();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return aluno;
	}
	
	
	
	public Aluno buscarUltimo() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Aluno aluno = null;

		try {
			Query consulta = sessao.getNamedQuery("Aluno.buscarUltimo");
			consulta.setMaxResults(1);
			
			aluno = (Aluno)consulta.uniqueResult();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return aluno;
		
	}
	
	
	public void excluir(Aluno aluno) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(aluno);
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
	
	public void editar(Aluno aluno) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(aluno);
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
