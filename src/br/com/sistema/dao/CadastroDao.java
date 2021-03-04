package br.com.sistema.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistema.domain.Cadastro;
import br.com.sistema.domain.Usuario;
import br.com.sistema.util.HibernateUtil;

public class CadastroDao {

	public void salvar(Cadastro cadastro) {
		
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(cadastro);
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
	public List<Cadastro> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Cadastro> cadastros = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Cadastro.listar");
			cadastros = consulta.list();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return cadastros;
	}	
	

	public Cadastro buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Cadastro cadastro = null;
		
		
		try {
			Query consulta = sessao.getNamedQuery("Cadastro.buscarPorCodigo");
			consulta.setLong("idCadastro", codigo);
			cadastro = (Cadastro) consulta.uniqueResult();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return cadastro;
	}

	
	public Cadastro buscarUltimo() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Cadastro cadastro = null;

		try {
			Query consulta = sessao.getNamedQuery("Cadastro.buscarUltimo");
			consulta.setMaxResults(1);
			
			cadastro = (Cadastro)consulta.uniqueResult();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return cadastro;
		
	}
	
	
	public void excluir(Cadastro cadastro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(cadastro);
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
	
	public void editar(Cadastro cadastro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(cadastro);
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