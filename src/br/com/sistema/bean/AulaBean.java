package br.com.sistema.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistema.dao.AulaDao;
import br.com.sistema.dao.CursoModuloDao;
import br.com.sistema.dao.EnsinoDao;
import br.com.sistema.dao.ProfessorDao;
import br.com.sistema.dao.TurmaDao;
import br.com.sistema.domain.Aula;
import br.com.sistema.domain.CursoModulo;
import br.com.sistema.domain.Ensino;
import br.com.sistema.domain.Professor;
import br.com.sistema.domain.Turma;
import br.com.sistema.util.FacesUtil;



@ManagedBean
@ViewScoped
public class AulaBean {
	
	
	private Aula aulaCadastro;
	private Turma turma;
	
	private CursoModulo curso;
	
	private List<Aula> listaAulas;// esse list terá todos os dados
	private List<Aula> listaAulasFiltrados;// esse list tera somente os filtrados
	
//	private List<Ensino> listaEnsinos;// esse list terá todos os dados
//	private List<Ensino> listaEnsinoFiltrados;
//	
	private List<Turma> listaTurmas;
//	private List<CursoModulo> listaCursos;
	
	
	private String acao;
	private Long codigo;
	
	
	public Aula getAulaCadastro() {
		
		return aulaCadastro;
	}
    
	public void setAulaCadastro(Aula aulaCadastro) {
		this.aulaCadastro = aulaCadastro;
	}
    
	public List<Turma> getListaTurmas() {
		return listaTurmas;
	}
    
	public void setListaTurmas(List<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}

	
//	public List<Turma> getListaTurmasFiltrados() {
//		return listaTurmasFiltrados;
//	}
//	
//	public void setListaTurmasFiltrados(List<Turma> listaTurmasFiltrados) {
//		this.listaTurmasFiltrados = listaTurmasFiltrados;
//	}
//	
	
	
//	public List<Ensino> getListaEnsinos() {
//		return listaEnsinos;
//	}
//	
//	public void setListaEnsinos(List<Ensino> listaEnsinos) {
//		this.listaEnsinos = listaEnsinos;
//	}
//	
//	
//	public List<Ensino> getListaEnsinoFiltrados() {
//		return listaEnsinoFiltrados;
//	}
//	
//	public void setListaEnsinoFiltrados(List<Ensino> listaEnsinoFiltrados) {
//		this.listaEnsinoFiltrados = listaEnsinoFiltrados;
//	}
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public void novo() {
		aulaCadastro = new Aula();

	}

	
	public List<Aula> getListaAulas() {
		return listaAulas;
	}

	public void setListaAulas(List<Aula> listaAulas) {
		this.listaAulas = listaAulas;
	}

	public List<Aula> getListaAulasFiltrados() {
		return listaAulasFiltrados;
	}

	public void setListaAulasFiltrados(List<Aula> listaAulasFiltrados) {
		this.listaAulasFiltrados = listaAulasFiltrados;
	}

	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public CursoModulo getCurso() {
		return curso;
	}
	
	
	public void setCurso(CursoModulo curso) {
		this.curso = curso;
	}
	
	
//	public Professor getProfessor() {
//		return professor;
//	}
//	
//	public void setProfessor(Professor professor) {
//		this.professor = professor;
//	}
	
//	public List<Professor> getListaProfessores() {
//		return listaProfessores;
//	}
//	
//	public void setListaProfessores(List<Professor> listaProfessores) {
//		this.listaProfessores = listaProfessores;
//	}
//	
//	public List<CursoModulo> getListaCursos() {
//		return listaCursos;
//	}
//	
//	public void setListaCursos(List<CursoModulo> listaCursos) {
//		this.listaCursos = listaCursos;
//	}
	
	public void salvar() {
		try {
			
			
			
			AulaDao aulaDao = new AulaDao();
			
			
			aulaDao.salvar(aulaCadastro);
			
			aulaCadastro = new Aula();

			//FacesUtil.adicionarMsgInfo("Aula criada com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar salvar a aula."+aulaCadastro);
		}
	}
	
	public void excluir() {
		try {
			AulaDao aulaDao = new AulaDao();
			aulaDao.excluir(aulaCadastro);

			FacesUtil.adicionarMsgInfo("Aula removida com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar remover a aula:" + ex.getMessage());
		}
	}
	
	
	public void editar() {
		try {
			
			AulaDao aulaDao = new AulaDao();
			aulaDao.editar(aulaCadastro);

			FacesUtil.adicionarMsgInfo("Aula editada com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar editar os dados da aula:" + ex.getMessage());
		}
	}
	
	
	public void carregarPesquisa() {
		
		try {
			AulaDao aulaDao = new AulaDao();
		    listaAulas = aulaDao.listar();


		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar listar as aulas:" + ex.getMessage());
		}
	}
	
	
	public void carregarCadastro() {
	
		try {
//			acao = FacesUtil.getParam("usuAcao");
//			String valor =FacesUtil.getParam("usuCod");
				
			if(codigo !=null) {
				AulaDao aulaDao = new AulaDao();
				aulaCadastro = aulaDao.buscarPorCodigo(codigo);
			}else {
				
				aulaCadastro = new Aula();
			}
			
			AulaDao aulaDao = new AulaDao();
//			CursoModuloDao cursoDao = new CursoModuloDao();
    		TurmaDao turmaDao = new TurmaDao();
			
			listaTurmas = turmaDao.listar();
			
//			listaCursos = cursoDao.listar();
//			
//			listaEnsinos = ensinoDao.listar();
			
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados da aula:" + ex.getMessage());
		}
	}
	
	
	
	
	
	public void carregarAulas() {

		try {
//			acao = FacesUtil.getParam("usuAcao");
//			String valor =FacesUtil.getParam("usuCod");

			if (codigo != null) {
				AulaDao aulaDao = new AulaDao();
				listaAulas = aulaDao.buscarPorChave(codigo);

			} else {

				// listaMatriculas = new Matricula();
			}

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados da aula:"+ex.getMessage());
		}
	}
	
	
	
	
	
	
	
	

}
