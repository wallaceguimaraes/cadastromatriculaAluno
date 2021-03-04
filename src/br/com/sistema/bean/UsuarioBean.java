package br.com.sistema.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistema.dao.UsuarioDao;
import br.com.sistema.domain.Usuario;
import br.com.sistema.util.FacesUtil;
import br.com.sistema.util.HibernateUtil;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private Usuario usuarioCadastro;
	private List<Usuario> listaUsuarios;// esse list terá todos os dados
	private List<Usuario> listaUsuariosFiltrados;// esse list tera somente os filtrados
	private String acao;
	private Long codigo;
	
	
	public Usuario getUsuarioCadastro() {
		
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(Usuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	
	public List<Usuario> getListaUsuariosFiltrados() {
		return listaUsuariosFiltrados;
	}
	
	public void setListaUsuariosFiltrados(List<Usuario> listaUsuariosFiltrados) {
		this.listaUsuariosFiltrados = listaUsuariosFiltrados;
	}
	
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public void novo() {
		usuarioCadastro = new Usuario();

	}

	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public void salvar() {
		try {
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.salvar(usuarioCadastro);
			usuarioCadastro = new Usuario();

			FacesUtil.adicionarMsgInfo("Usuário salvo com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar salvar o usuário:" + ex.getMessage());
		}
	}
	
	public void excluir() {
		try {
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.excluir(usuarioCadastro);

			FacesUtil.adicionarMsgInfo("Usuário excluído com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar excluir o usuário:" + ex.getMessage());
		}
	}
	
	
	public void editar() {
		try {
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.editar(usuarioCadastro);

			FacesUtil.adicionarMsgInfo("Usuário editado com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar editar os dados do usuário:" + ex.getMessage());
		}
	}
	
	
	public void carregarPesquisa() {
		
		try {
			UsuarioDao usuarioDao = new UsuarioDao();
		    listaUsuarios = usuarioDao.listar();


		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar listar os usuários:" + ex.getMessage());
		}
	}
	
	
	public void carregarCadastro() {
	
		try {
//			acao = FacesUtil.getParam("usuAcao");
//			String valor =FacesUtil.getParam("usuCod");
				
			if(codigo != null) {
				UsuarioDao usuarioDao = new UsuarioDao();
				usuarioCadastro = usuarioDao.buscarPorCodigo(codigo);
			}else {
				
				usuarioCadastro = new Usuario();
			}

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados do usuário:" + ex.getMessage());
		}
	}
	

	public void criarTabela() {
		FacesUtil.adicionarMsgInfo("Tabela atualizada!");
		HibernateUtil.getSessionFactory();

	}
}
