package br.com.sistema.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistema.domain.Usuario;
import br.com.sistema.util.FacesUtil;
import br.com.sistema.util.HibernateUtil;

public class UsuarioDao {

	public void salvar(Usuario usuario) {// throws Exception {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();
			sessao.save(usuario);
			transacao.commit();
		} catch (Exception ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> usuarios = null;

		try {
			Query consulta = sessao.getNamedQuery("Usuario.listar");
			usuarios = consulta.list();

		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return usuarios;
	}

	public Usuario buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;

		try {
			Query consulta = sessao.getNamedQuery("Usuario.buscarPorCodigo");
			consulta.setLong("idUsuario", codigo);// codig esquerda é o:codigo e o direita é o recebido do metodo

			usuario = (Usuario) consulta.uniqueResult();

		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return usuario;
	}

	public void excluir(Usuario usuario) {// esse metodo é util quando todos os dados do usuario estao preenchidos

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();
			sessao.delete(usuario);
			transacao.commit();
		} catch (Exception ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}

	}

//	public void excluir(Long codigo) {//quando n se tem certeza de ter todos os dados usasse o que exclui pela chave primaria
//
//		Session sessao = HibernateUtil.getSessionFactory().openSession();
//		Transaction transacao = null;
//
//		try {
//
//			transacao = sessao.beginTransaction();
//			Usuario usuario = buscarPorCodigo(codigo);
//
//			sessao.delete(usuario);
//			transacao.commit();
//		} catch (Exception ex) {
//			if (transacao != null) {
//				transacao.rollback();
//			}
//			throw ex;
//		} finally {
//			sessao.close();
//		}
//
//	}

	
	
	public void editar(Usuario usuario) {// throws Exception {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();
			
//			Usuario usuarioEditar = buscarPorCodigo(usuario.getIdUsuario());
//			usuarioEditar.setNomeUsuario(usuario.getNomeUsuario());
//			usuarioEditar.setLogin(usuario.getLogin());
//			usuarioEditar.setSenha(usuario.getSenha());
//			usuarioEditar.setEmail(usuario.getEmail());
//			usuarioEditar.setFuncaoUsuario(usuario.getFuncaoUsuario());
//			sessao.update(usuarioEditar);
//			
			sessao.update(usuario);// para atualizar assim é preciso ter certeza q todos os dados foram preenchidos inclusive os not null
			transacao.commit();
		} catch (Exception ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}

	}
	
	
	public Usuario autenticar(String login, String senha) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;

		try {

			Query consulta = sessao.getNamedQuery("Usuario.autenticar");
			consulta.setString("login",login);// codig esquerda é o:codigo e o direita é o recebido do metodo	
			consulta.setString("senha",senha);
			
			usuario = (Usuario)consulta.uniqueResult();

		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}

		return usuario;
	}
		
	}
	
	

