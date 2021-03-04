package br.com.sistema.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistema.dao.AlunoDao;
import br.com.sistema.dao.AtividadeDao;
import br.com.sistema.dao.ProfessorDao;
import br.com.sistema.dao.UsuarioDao;
import br.com.sistema.domain.Aluno;
import br.com.sistema.domain.Atividade;
import br.com.sistema.domain.Usuario;
import br.com.sistema.util.FacesUtil;


@ManagedBean
@ViewScoped
public class AtividadeBean {
	

	
	private Atividade atividadeCadastro;
	private List<Atividade> listaAtividades;// esse list terá todos os dados
	private List<Atividade> listaAtividadesFiltrados;// esse list tera somente os filtrados
	
	private String acao;
	private Long codigo;
	public Atividade getAtividadeCadastro() {
		return atividadeCadastro;
	}
	public void setAtividadeCadastro(Atividade atividadeCadastro) {
		this.atividadeCadastro = atividadeCadastro;
	}
	public List<Atividade> getListaAtividades() {
		return listaAtividades;
	}
	public void setListaAtividades(List<Atividade> listaAtividades) {
		this.listaAtividades = listaAtividades;
	}
	public List<Atividade> getListaAtividadesFiltrados() {
		return listaAtividadesFiltrados;
	}
	public void setListaAtividadesFiltrados(List<Atividade> listaAtividadesFiltrados) {
		this.listaAtividadesFiltrados = listaAtividadesFiltrados;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	
	
public void carregarPesquisa() {
		
		try {
			AtividadeDao atividadeDao = new AtividadeDao();
		    listaAtividades = atividadeDao.listar();


		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar listar as atividades:" + ex.getMessage());
		}
	}
	


public void carregarAtividadesCadastro() {
	
	try {
//		acao = FacesUtil.getParam("usuAcao");
//		String valor =FacesUtil.getParam("usuCod");
			
		if(codigo != null) {
			//UsuarioDao usuarioDao = new UsuarioDao();
			//usuarioCadastro = usuarioDao.buscarPorCodigo(codigo);
            AtividadeDao atividadeDao = new AtividadeDao();
            
            listaAtividades = atividadeDao.buscarPorCodigo(codigo);
		
		}else {

			FacesUtil.adicionarMsgErro("Codigo vazio!");

			//usuarioCadastro = new Usuario();
		}

	} catch (RuntimeException ex) {
		FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados das atividades:" + ex.getMessage());
	}
}




public void excluir() {
	try {
		AtividadeDao atividadeDao = new AtividadeDao();
		atividadeDao.excluir(atividadeCadastro);

		FacesUtil.adicionarMsgInfo("Atividade excluída com sucesso!");
		
		
		
		

	} catch (RuntimeException ex) {
		FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar excluir a atividade:" + ex.getMessage());
	}
}


	
}