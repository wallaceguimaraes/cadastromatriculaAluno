package br.com.sistema.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.sistema.dao.UsuarioDao;
import br.com.sistema.domain.Usuario;
import br.com.sistema.util.FacesUtil;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {

	private Usuario usuarioLogado;

	public Usuario getUsuarioLogado() {
		if (usuarioLogado == null) {
			usuarioLogado = new Usuario();
		}
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public void autenticar() {
		try {

			
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioLogado = usuarioDao.autenticar(usuarioLogado.getLogin(), usuarioLogado.getSenha());
			
			if(usuarioLogado == null) {
				FacesUtil.adicionarMsgErro("Login e/ou senha inválidos ou o usuário pode estar inativo!");
			}else {
			FacesUtil.adicionarMsgInfo("Usuário autenticado com sucesso!");
			}
		} catch (RuntimeException er) {
			FacesUtil.adicionarMsgErro("Erro ao tentar autenticar no sistema!" + er.getMessage());

		}

	}

	public String sair() {
		
		usuarioLogado = null;
	return "/pages/autenticacao.xhtml?faces-redirect=true";
	
	}
	
}
