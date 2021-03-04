package br.com.sistema.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.sistema.dao.AulaDao;
import br.com.sistema.dao.CadastroDao;
import br.com.sistema.dao.CursoModuloDao;
import br.com.sistema.dao.EnsinoDao;
import br.com.sistema.dao.MatriculaDao;
import br.com.sistema.dao.ProfessorDao;
import br.com.sistema.dao.TurmaDao;
import br.com.sistema.domain.Aula;
import br.com.sistema.domain.Cadastro;
import br.com.sistema.domain.CursoModulo;
import br.com.sistema.domain.Ensino;
import br.com.sistema.domain.Matricula;
import br.com.sistema.domain.Professor;
import br.com.sistema.domain.Turma;
import br.com.sistema.util.FacesUtil;
import br.com.sistema.util.HibernateUtil;

@ManagedBean
@ViewScoped
public class TurmaBean {

	private Turma turmaCadastro;
	private Professor professor;

	private Long ensCod;
	private CursoModulo curso;

	private List<Aula> listaAulas;

	private List<Turma> listaTurmas;// esse list terá todos os dados
	private List<Turma> listaTurmasFiltrados;// esse list tera somente os filtrados

	private List<Ensino> listaEnsinos;// esse list terá todos os dados
	private List<Ensino> listaEnsinoFiltrados;

	private List<Professor> listaProfessores;
	private List<CursoModulo> listaCursos;

	private String acao;
	private Long codigo;

	private String dia;

	private String horario;

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public List<Aula> getListaAulas() {

		if (listaAulas == null) {
			listaAulas = new ArrayList<>();
		}
		return listaAulas;
	}

	public void setListaAulas(List<Aula> listaAulas) {
		this.listaAulas = listaAulas;
	}

	public Turma getTurmaCadastro() {

		return turmaCadastro;
	}

	public void setTurmaCadastro(Turma turmaCadastro) {
		this.turmaCadastro = turmaCadastro;
	}

	public List<Turma> getListaTurmas() {
		return listaTurmas;
	}

	public void setListaTurmas(List<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}

	public List<Turma> getListaTurmasFiltrados() {
		return listaTurmasFiltrados;
	}

	public void setListaTurmasFiltrados(List<Turma> listaTurmasFiltrados) {
		this.listaTurmasFiltrados = listaTurmasFiltrados;
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

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public void novo() {
		turmaCadastro = new Turma();

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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getListaProfessores() {
		return listaProfessores;
	}

	public void setListaProfessores(List<Professor> listaProfessores) {
		this.listaProfessores = listaProfessores;
	}

	public List<CursoModulo> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<CursoModulo> listaCursos) {
		this.listaCursos = listaCursos;
	}
	
	
	
	

	public Long getEnsCod() {
		return ensCod;
	}

	public void setEnsCod(Long ensCod) {
		this.ensCod = ensCod;
	}

	public void salvar() {
		try {

			TurmaDao turmaDao = new TurmaDao();

			// FacesUtil.adicionarMsgInfo(" "+turmaCadastro);

			turmaDao.salvar(turmaCadastro);

			// turmaCadastro = new Turma();

			// salvarAulas();

			AulaDao aulaDao = new AulaDao();
			// TurmaDao turmaDao = new TurmaDao();
			// aulaDao.salvar();
			Aula aula = new Aula();
			Turma turma = new Turma();

			for (int i = 0; i < listaAulas.size(); i++) {
				
				try {
				aula = listaAulas.get(i);				
				
				turma = turmaDao.buscarUltimo();
				aula.setTurma(turma);
				aulaDao.salvar(aula);
				
				//FacesUtil.adicionarMsgInfo(" "+aula+i);

				} catch (RuntimeException er) {
					FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar salvar a aula." + aula);

				}

			}

			FacesUtil.adicionarMsgInfo("Turma criada com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar salvar a turma.");
		}
	}

	public void salvarAulas() {

		AulaDao aulaDao = new AulaDao();
		TurmaDao turmaDao = new TurmaDao();
		// aulaDao.salvar();
		Aula aula = new Aula();
		Turma turma = new Turma();

		for (int i = 0; listaAulas.size() > i; i++) {
			aula = listaAulas.get(i);
			turma = turmaDao.buscarUltimo();
			aula.setTurma(turma);

			aulaDao.salvar(aula);

		}
		// aulaDao.salvar(listaAulas);

	}

	public void excluir() {
		try {
			TurmaDao turmaDao = new TurmaDao();
			turmaDao.excluir(turmaCadastro);

			FacesUtil.adicionarMsgInfo("Turma removida com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar remover a turma:" + ex.getMessage());
		}
	}

	public void editar() {
		try {

			TurmaDao turmaDao = new TurmaDao();
			turmaDao.editar(turmaCadastro);

			FacesUtil.adicionarMsgInfo("Turma editada com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar editar os dados da turma:" + ex.getMessage());
		}
	}

	public void carregarPesquisa() {

		try {
			TurmaDao turmaDao = new TurmaDao();
			listaTurmas = turmaDao.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar listar as turmas:" + ex.getMessage());
		}
	}

	public void carregarCadastro() {

		try {
//			acao = FacesUtil.getParam("usuAcao");
//			String valor =FacesUtil.getParam("usuCod");

			if (codigo != null) {
				TurmaDao turmaDao = new TurmaDao();
				turmaCadastro = turmaDao.buscarPorCodigo(codigo);
			} else {

				turmaCadastro = new Turma();
			}

			ProfessorDao professorDao = new ProfessorDao();
			CursoModuloDao cursoDao = new CursoModuloDao();
			EnsinoDao ensinoDao = new EnsinoDao();

			listaProfessores = professorDao.listar();

			listaCursos = cursoDao.listar();

			listaEnsinos = ensinoDao.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados da turma:" + ex.getMessage());
		}
	}

	public void adicionar() {
		Aula aula = new Aula();
		// String dia =FacesUtil.getParam("dia");
		// String horario =FacesUtil.getParam("horario");

//		for(int pos = 0; pos < listaAulas ) {
//			
//			
//		}
//		

		aula.setDia(dia);
		aula.setHorario(horario);
		listaAulas.add(aula);

		//FacesUtil.adicionarMsgInfo("" + listaAulas.size());

	}

	
	public void remover() {
		//int posicaoEncontrada = -1;
		
	//	for(int pos = 0;pos < listaAulas.size() && posicaoEncontrada < 0 ;pos++) {
	//		Aula aulaTemp = listaAulas.get(pos);
			
//			if(aulaTemp.getIdAula()) {
//				
//			}
//			
		    String cod = FacesUtil.getParam("co");

		   
		    
		    FacesUtil.adicionarMsgInfo("Codigo");

			listaAulas.remove(Integer.parseInt(cod));
			
			//FacesUtil.adicionarMsgInfo("" + aulaTemp.getIdAula());

			
			
		//}
		
	}
	

	public void carregarTurmas() {

		try {
//			acao = FacesUtil.getParam("usuAcao");
//			String valor =FacesUtil.getParam("usuCod");

			if (codigo != null) {
				TurmaDao turmaDao = new TurmaDao();
				listaTurmas = turmaDao.buscarPorChave(codigo);

			} else {

				// listaMatriculas = new Matricula();
			}

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados da turma:" + ex.getMessage());
		}
	}
	
	

	public void carregarProfessores() {

		try {
//			acao = FacesUtil.getParam("usuAcao");
//			String valor =FacesUtil.getParam("usuCod");

			if (codigo != null) {
				TurmaDao turmaDao = new TurmaDao();
				listaTurmas = turmaDao.buscarPorDisciplina(codigo);

			} else {

				// listaMatriculas = new Matricula();
			}

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados da turma:" + ex.getMessage());
		}
	}
	
	

}
