package br.com.sistema.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistema.dao.CadastroDao;
import br.com.sistema.dao.CursoModuloDao;
import br.com.sistema.dao.EnsinoDao;
import br.com.sistema.dao.ProfessorDao;
import br.com.sistema.dao.TurmaDao;
import br.com.sistema.domain.Cadastro;
import br.com.sistema.domain.CursoModulo;
import br.com.sistema.domain.Ensino;
import br.com.sistema.domain.Professor;
import br.com.sistema.util.FacesUtil;

@ManagedBean
@ViewScoped
public class CursoModuloBean {

	private CursoModulo cursoModuloCadastro;
	private List<CursoModulo> listaCursoModulos;// esse list terá todos os dados
	private List<CursoModulo> listaCursoModulosFiltrados;// esse list tera somente os filtrados
	
	private List<Ensino> listaEnsinos;// esse list terá todos os dados
	private List<Ensino> listaEnsinoFiltrados;
	
	
	private String acao;
	private Long codigo;
	private Long ensCod;
	
	
	
	
	
	public Long getEnsCod() {
		return ensCod;
	}

	public void setEnsCod(Long ensCod) {
		this.ensCod = ensCod;
	}

	public void setListaCursoModulos(List<CursoModulo> listaCursoModulos) {
		this.listaCursoModulos = listaCursoModulos;
	}

	public CursoModulo getCursoModuloCadastro() {
		
		return cursoModuloCadastro;
	}
    
	public void setCursoModuloCadastro(CursoModulo cursoModuloCadastro) {
		this.cursoModuloCadastro = cursoModuloCadastro;
	}
    
	public List<CursoModulo> getListaCursoModulos() {
		return listaCursoModulos;
	}
    
	public void setListaCursomodulos(List<CursoModulo> listaCursoModulos) {
		this.listaCursoModulos = listaCursoModulos;
	}

	
	public List<CursoModulo> getListaCursoModulosFiltrados() {
		return listaCursoModulosFiltrados;
	}
	
	public void setListaCursoModulosFiltrados(List<CursoModulo> listaCursoModulosFiltrados) {
		this.listaCursoModulosFiltrados = listaCursoModulosFiltrados;
	}
	
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public void novo() {
		cursoModuloCadastro = new CursoModulo();

	}

	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	
	
	
	
	public List<Ensino> getListaEnsinos() {
		return listaEnsinos;
	}

	public void setListaEnsinos(List<Ensino> listaEnsinos) {
		this.listaEnsinos = listaEnsinos;
	}

	public List<Ensino> getListaEnsinoFiltrados() {
		return listaEnsinoFiltrados;
	}

	public void setListaEnsinoFiltrados(List<Ensino> listaEnsinoFiltrados) {
		this.listaEnsinoFiltrados = listaEnsinoFiltrados;
	}

	public void salvar() {
		try {
			
			Cadastro cadastro = new Cadastro();
			CadastroDao cadastroDao = new CadastroDao();
			
			cadastro = cadastroDao.buscarUltimo();
			
			
			CursoModuloDao cursoModuloDao = new CursoModuloDao();
			cursoModuloCadastro.setCadastro(cadastro);
			cursoModuloDao.salvar(cursoModuloCadastro);
			cursoModuloCadastro = new CursoModulo();

			FacesUtil.adicionarMsgInfo("Cadastrado com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar cadastrar!" + ex.getMessage());
		}
	}
	
	public void excluir() {
		try {
			CursoModuloDao cursoModuloDao = new CursoModuloDao();
			cursoModuloDao.excluir(cursoModuloCadastro);

			FacesUtil.adicionarMsgInfo("Excluído com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar excluir!" + ex.getMessage());
		}
	}
	
	
	public void editar() {
		try {
			CursoModuloDao cursoModuloDao = new CursoModuloDao();
			cursoModuloDao.editar(cursoModuloCadastro);

			FacesUtil.adicionarMsgInfo("Editado com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar editar!" + ex.getMessage());
		}
	}
	
	
	public void carregarPesquisa() {
		
		try {
			CursoModuloDao cursoModuloDao = new CursoModuloDao();
		    listaCursoModulos = cursoModuloDao.listar();


		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar listar!" + ex.getMessage());
		}
	}
	
	
	

	
	
	
	
	public void carregarCadastro() {
	
		try {
//			acao = FacesUtil.getParam("usuAcao");
//			String valor =FacesUtil.getParam("usuCod");
				
			if(codigo !=null) {
				CursoModuloDao cursoModuloDao = new CursoModuloDao();
				cursoModuloCadastro = cursoModuloDao.buscarPorCodigo(codigo);
				
				
				
			}else {
				
				cursoModuloCadastro = new CursoModulo();
			}

			EnsinoDao ensinoDao = new EnsinoDao();
			
			
			
			listaEnsinos = ensinoDao.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados do getParam!" + ex.getMessage());
		}
	}	
	
	
	
	
	
	
}
