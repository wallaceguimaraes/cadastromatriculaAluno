package br.com.sistema.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistema.dao.CadastroDao;
import br.com.sistema.dao.CursoModuloDao;
import br.com.sistema.dao.EnsinoDao;
import br.com.sistema.domain.Cadastro;
import br.com.sistema.domain.Ensino;
import br.com.sistema.util.FacesUtil;


@ManagedBean
@ViewScoped
public class EnsinoBean {

	
	private Ensino ensinoCadastro;
	private List<Ensino> listaEnsinos;// esse list terá todos os dados
	private List<Ensino> listaEnsinoFiltrados;// esse list tera somente os filtrados
	
	private String acao;
	private Long codigo;
	
	
	public Ensino getEnsinoCadastro() {
		
		return ensinoCadastro;
	}
    
	public void setEnsinoCadastro(Ensino ensinoCadastro) {
		this.ensinoCadastro = ensinoCadastro;
	}
    
	public List<Ensino> getListaEnsinos() {
		return listaEnsinos;
	}
    
	public void setListaCursomodulos(List<Ensino> listaEnsinos) {
		this.listaEnsinos = listaEnsinos;
	}

	
	public List<Ensino> getListaEnsinosFiltrados() {
		return listaEnsinoFiltrados;
	}
	
	public void setListaEnsinoFiltrados(List<Ensino> listaEnsinoFiltrados) {
		this.listaEnsinoFiltrados = listaEnsinoFiltrados;
	}
	
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public void novo() {
		ensinoCadastro = new Ensino();

	}

	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public void salvar() {
		try {
			
			Cadastro cadastro = new Cadastro();
			CadastroDao cadastroDao = new CadastroDao();
			
			cadastro = cadastroDao.buscarUltimo();
			
			
			EnsinoDao ensinoDao = new EnsinoDao();
			ensinoDao.salvar(ensinoCadastro);
			ensinoCadastro = new Ensino();

			FacesUtil.adicionarMsgInfo("Ensino salvo com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar salvar o ensino:" + ex.getMessage());
		}
	}
	
	public void excluir() {
		try {
			EnsinoDao ensinoDao = new EnsinoDao();
			ensinoDao.excluir(ensinoCadastro);

			FacesUtil.adicionarMsgInfo("Ensino excluído com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar excluir o ensino:" + ex.getMessage());
		}
	}
	
	
	public void editar() {
		try {
			EnsinoDao ensinoDao = new EnsinoDao();
			ensinoDao.editar(ensinoCadastro);

			FacesUtil.adicionarMsgInfo("Ensino editado com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar editar o ensino:" + ex.getMessage());
		}
	}
	
	
	public void carregarPesquisa() {
		
		try {
			EnsinoDao ensinoDao = new EnsinoDao();
		    listaEnsinos = ensinoDao.listar();


		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar listar os ensinos:" + ex.getMessage());
		}
	}
	
	
	public void carregarCadastro() {
	
		try {
//			acao = FacesUtil.getParam("usuAcao");
//			String valor =FacesUtil.getParam("usuCod");
				
			if(codigo !=null) {
				EnsinoDao ensinoDao = new EnsinoDao();
				ensinoCadastro = ensinoDao.buscarPorCodigo(codigo);
			}else {
				
				ensinoCadastro = new Ensino();
			}

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados do ensino:" + ex.getMessage());
		}
	}	
	
	
	
	
	
	
	
	
	
	
	
}
