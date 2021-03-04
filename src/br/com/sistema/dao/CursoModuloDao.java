package br.com.sistema.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistema.domain.Cadastro;
import br.com.sistema.domain.CursoModulo;
import br.com.sistema.domain.Matricula;
import br.com.sistema.util.HibernateUtil;

public class CursoModuloDao {
	
public void salvar(CursoModulo cursomodulo) {
		
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(cursomodulo);
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
	public List<CursoModulo> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<CursoModulo> cursomodulos = null;
		
		try {
			Query consulta = sessao.getNamedQuery("CursoModulo.listar");
			cursomodulos = consulta.list();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return cursomodulos;
	}	
	

	public CursoModulo buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		CursoModulo cursomodulo = null;
		
		try {
			Query consulta = sessao.getNamedQuery("CursoModulo.buscarPorCodigo");
			consulta.setLong("idCursoModulo", codigo);
			cursomodulo = (CursoModulo) consulta.uniqueResult();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return cursomodulo;
	}
	
	
	public void excluir(CursoModulo cursomodulo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(cursomodulo);
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
	
	
	
	public List<CursoModulo> buscarPorChaveEnsino(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<CursoModulo> disciplinas = null;
		
		try {
			Query consulta = sessao.getNamedQuery("CursoModulo.buscarPorChaveEnsino");
			consulta.setLong("ensino", codigo);
			disciplinas = consulta.list();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return disciplinas;
	}
	
	
	
	
	public void editar(CursoModulo cursomodulo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(cursomodulo);
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
