package br.com.sistema.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.mysql.fabric.xmlrpc.base.Array;

import br.com.sistema.dao.AlunoDao;
import br.com.sistema.dao.AtividadeDao;
import br.com.sistema.dao.CursoModuloDao;
import br.com.sistema.dao.EnsinoDao;
import br.com.sistema.dao.MatriculaDao;
import br.com.sistema.dao.TurmaDao;
import br.com.sistema.dao.UsuarioDao;
import br.com.sistema.domain.Aluno;
import br.com.sistema.domain.Atividade;
import br.com.sistema.domain.CursoModulo;
import br.com.sistema.domain.Ensino;
import br.com.sistema.domain.Matricula;
import br.com.sistema.domain.Turma;
import br.com.sistema.domain.Usuario;
import br.com.sistema.util.FacesUtil;

@ManagedBean
@ViewScoped
public class MatriculaBean {

	private List<Aluno> listaAlunos;
	private List<Aluno> listaAlunosFiltrados;

	private List<Turma> listaTurmas;
	private List<Turma> listaTurmasFiltradas;

	private List<Ensino> listaEnsinos;
	private List<Ensino> listaEnsinosFiltradas;

	private List<Matricula> listaMatriculas;

	private Long codigo;
	private Long ensCod;
	private Long turCod;
	
	private Matricula stMatricula;

	private List<Matricula> matricul;

	private List<CursoModulo> listaCursoModulos;

	private List<CursoModulo> listaCursoModulosFiltrados;

	@ManagedProperty(value = "#{autenticacaoBean}")
	private AutenticacaoBean autenticacaoBean;

	
	
	
	
	public Long getTurCod() {
		return turCod;
	}

	public void setTurCod(Long turCod) {
		this.turCod = turCod;
	}

	public List<CursoModulo> getListaCursoModulos() {
		return listaCursoModulos;
	}

	public void setListaCursoModulos(List<CursoModulo> listaCursoModulos) {
		this.listaCursoModulos = listaCursoModulos;
	}

	public List<CursoModulo> getListaCursoModulosFiltrados() {
		return listaCursoModulosFiltrados;
	}

	public void setListaCursoModulosFiltrados(List<CursoModulo> listaCursoModulosFiltrados) {
		this.listaCursoModulosFiltrados = listaCursoModulosFiltrados;
	}

	public Long getEnsCod() {
		return ensCod;
	}

	public void setEnsCod(Long ensCod) {
		this.ensCod = ensCod;
	}

	public Matricula getStMatricula() {
		return stMatricula;
	}

	public void setStMatricula(Matricula stMatricula) {
		this.stMatricula = stMatricula;
	}

	public AutenticacaoBean getAutenticacaoBean() {
		return autenticacaoBean;
	}

	public void setAutenticacaoBean(AutenticacaoBean autenticacaoBean) {
		this.autenticacaoBean = autenticacaoBean;
	}

	// private Matricula matricula;

//public List<Aluno> getListaAlunos() {
//	return listaAlunos;
//}
//
//public void setListaAlunos(List<Aluno> listaAlunos) {
//	this.listaAlunos = listaAlunos;
//}
//
//public List<Aluno> getListaAlunosFiltrados() {
//	return listaAlunosFiltrados;
//}
//
//public void setListaAlunosFiltrados(List<Aluno> listaAlunosFiltrados) {
//	this.listaAlunosFiltrados = listaAlunosFiltrados;
//}

	public Long getCodigo() {
		return codigo;
	}

	public List<Ensino> getListaEnsinos() {
		return listaEnsinos;
	}

	public void setListaEnsinos(List<Ensino> listaEnsinos) {
		this.listaEnsinos = listaEnsinos;
	}

	public List<Ensino> getListaEnsinosFiltradas() {
		return listaEnsinosFiltradas;
	}

	public void setListaEnsinosFiltradas(List<Ensino> listaEnsinosFiltradas) {
		this.listaEnsinosFiltradas = listaEnsinosFiltradas;
	}

	public List<Matricula> getMatricul() {
		return matricul;
	}

	public void setMatricul(List<Matricula> matricul) {
		this.matricul = matricul;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public List<Matricula> getListaMatriculas() {
		if (listaMatriculas == null) {
			listaMatriculas = new ArrayList<>();
		}

		return listaMatriculas;
	}

	public void setListaMatriculas(List<Matricula> listaMatriculas) {
		this.listaMatriculas = listaMatriculas;
	}

	public List<Turma> getListaTurmas() {
		return listaTurmas;
	}

	public void setListaTurmas(List<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}

	public List<Turma> getListaTurmasFiltradas() {
		return listaTurmasFiltradas;
	}

	public void setListaTurmasFiltradas(List<Turma> listaTurmasFiltradas) {
		this.listaTurmasFiltradas = listaTurmasFiltradas;
	}

	public void carregarAlunos() {

		try {
			AlunoDao alunoDao = new AlunoDao();
			listaAlunos = alunoDao.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar listar os alunos:" + ex.getMessage());
		}
	}

	public void carregarTurmas() {
		try {
			TurmaDao turmaDao = new TurmaDao();
			listaTurmas = turmaDao.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar listar as turmas:" + ex.getMessage());
		}

	}

	public void carregarEnsinos() {
		try {
			EnsinoDao ensinoDao = new EnsinoDao();
			MatriculaDao matDao = new MatriculaDao();
			listaEnsinos = ensinoDao.listar();
			listaMatriculas = matDao.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar listar os cursos:" + ex.getMessage());
		}

	}

	public void carregarMatriculas() {
		try {
			MatriculaDao matriculaDao = new MatriculaDao();
			listaMatriculas = matriculaDao.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar listar os alunos:" + ex.getMessage());
		}

	}

	public void selecionar(Aluno alunoSelecionado) {
		// System.out.println(alunoSelecionado);
		// FacesUtil.adicionarMsgInfo("Aluno:"+alunoSelecionado);

		Matricula matricula = new Matricula();
		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		data = new Date(formatador.format(data));

		matricula.setDataMatricula(data);
		matricula.setAluno(alunoSelecionado);
		matricula.setStMatricula("Ativa");
		// matricula.setNumeroMatricula("201900001");
		listaMatriculas.add(matricula);

		// FacesUtil.adicionarMsgInfo("Matricula:"+matricul);

	}

//	public void matricular(Turma turmaSelecionada) {
//		// System.out.println(alunoSelecionado);
//		// FacesUtil.adicionarMsgInfo("Aluno:"+alunoSelecionado);
//		Matricula matricula = new Matricula();
//		Atividade atividade = new Atividade();
//		Matricula matricula1 = null;
//		Matricula matricula2 = null;
//
//		try {
//			
//			AtividadeDao atividadeDao = new AtividadeDao();
//
//			MatriculaDao matriculaDao = new MatriculaDao();
//
//			Date data = new Date();
//			SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//			data = new Date(formatador.format(data));
//
//			Aluno aluno = new Aluno();
//			AlunoDao alunoDao = new AlunoDao();
//			aluno = alunoDao.buscarPorCodigo(codigo);
//			aluno.setSituacao("Matriculado");
//			alunoDao.editar(aluno);
//			aluno = alunoDao.buscarPorCodigo(codigo);
//
//            //Buscar ultima matricula para gerar N° matricula
//			matricula1 = matriculaDao.buscarUltimo();
//			Integer numero = matricula1.getNumeroMatricula();
//			matricula.setNumeroMatricula(numero + 1);
//
//		    //matricula.setNumeroMatricula(2019000001);			
//		    matricula.setStMatricula("Ativa");
//			matricula.setTurma(turmaSelecionada);
//
//			matricula.setAluno(aluno);
//			matricula.setDataMatricula(data);
//
//			// Verificador
//			matricula2 = matriculaDao.buscarPorAlunoTurma(codigo, turmaSelecionada.getIdTurma());
//			if (matricula2 != null) {
//				FacesUtil.adicionarMsgErro("Não é possível matricular o aluno na mesma turma!");
//			} else {
//				matriculaDao.salvar(matricula);
//				// listaMatriculas.add(matricula);
//				try {
//					Usuario usuario = new Usuario();
//
//					usuario = autenticacaoBean.getUsuarioLogado();
//
//					atividade.setMatricula(matricula);
//					atividade.setAluno(aluno);
//					atividade.setDtAtividade(data);
//					atividade.setUsuario(usuario);
//					atividade.setTipoAtividade("Matrícula de aluno");
//
//					atividadeDao.salvar(atividade);
//
//				} catch (RuntimeException ex) {
//					FacesUtil.adicionarMsgErro("Erro ao tentar cadastrar Atividade!" + atividade);
//
//				}
//
//				FacesUtil.adicionarMsgInfo("Matriculado com sucesso!");
//
//			}
//		} catch (RuntimeException er) {
//			FacesUtil.adicionarMsgErro("Erro ao matricular!");
//
//		}
//
//	}
//	

	public void matricularEnsino(Turma turmaSelecionada) {
		// System.out.println(alunoSelecionado);
		// FacesUtil.adicionarMsgInfo("Aluno:"+alunoSelecionado);
		Matricula matricula = new Matricula();
		Atividade atividade = new Atividade();
		Matricula matricula1 = null;
		Matricula matricula2 = null;

		try {

			AtividadeDao atividadeDao = new AtividadeDao();

			MatriculaDao matriculaDao = new MatriculaDao();

			Date data = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			data = new Date(formatador.format(data));

			Aluno aluno = new Aluno();
			AlunoDao alunoDao = new AlunoDao();
			aluno = alunoDao.buscarPorCodigo(codigo);
			aluno.setSituacao("Matriculado");
			alunoDao.editar(aluno);

			aluno = alunoDao.buscarPorCodigo(codigo);

			// Buscar ultima matricula para gerar N° matricula
			matricula1 = matriculaDao.buscarUltimo();
			Integer numero = matricula1.getNumeroMatricula();
			matricula.setNumeroMatricula(numero + 1);

			// matricula.setNumeroMatricula(2019000001);
			matricula.setStMatricula("Ativa");
			//matricula.setEnsino(turmaSelecionada);

			matricula.setAluno(aluno);
			matricula.setDataMatricula(data);

			// Verificador

			//matricula2 = matriculaDao.buscarPorAlunoEnsino(codigo, ensinoSelecionado.getIdEnsino());
			if (matricula2 != null) {

			

					FacesUtil.adicionarMsgErro("O aluno já está matriculado nesse curso!");
				

			} else {
				matriculaDao.salvar(matricula);
				// listaMatriculas.add(matricula);
				try {
					Usuario usuario = new Usuario();

					usuario = autenticacaoBean.getUsuarioLogado();

					atividade.setMatricula(matricula);
					atividade.setAluno(aluno);
					atividade.setDtAtividade(data);
					atividade.setUsuario(usuario);
					atividade.setTipoAtividade("Matrícula de aluno");

					atividadeDao.salvar(atividade);

				} catch (RuntimeException ex) {
					FacesUtil.adicionarMsgErro("Erro ao tentar cadastrar Atividade!" + atividade);

				}

				FacesUtil.adicionarMsgInfo("Matriculado com sucesso!");

			}
		} catch (RuntimeException er) {
			FacesUtil.adicionarMsgErro("Erro ao matricular!");

		}

	}
	
	
	
//	public void rematricular() {
//		
//		
//		
//		
//		if (matricula2.getStMatricula().equalsIgnoreCase("Cancelada")) {
//
//			matricula2.setStMatricula("Ativa");
//			matriculaDao.editar(matricula2);
//
//			FacesUtil.adicionarMsgInfo("A matrícula foi ativa novamente!");
//
//			try {
//
//			Date dat = new Date();
//			SimpleDateFormat formatado = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//			data = new Date(formatado.format(dat));
//			
//			Usuario usuario = new Usuario();
//
//			usuario = autenticacaoBean.getUsuarioLogado();
//
//			atividade.setMatricula(matricula);
//			atividade.setAluno(aluno);
//			atividade.setDtAtividade(dat);
//			atividade.setUsuario(usuario);
//			atividade.setTipoAtividade("Rematrícula de aluno");
//
//			atividadeDao.salvar(atividade);	
//			
//			}catch(RuntimeException ex) {
//				FacesUtil.adicionarMsgErro("Erro ao rematricular!"+atividade);
//
//			}
//		
//		}
//	}
	

	public void carregarEmentas() {

		
		
		
		try {
//			acao = FacesUtil.getParam("usuAcao");
//			String valor =FacesUtil.getParam("usuCod");

			if (ensCod != null) {
				CursoModuloDao cursoModuloDao = new CursoModuloDao();
				listaCursoModulos = cursoModuloDao.buscarPorChaveEnsino(ensCod);

			} else {

				// listaMatriculas = new Matricula();
			}

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados da ementa:" + ex.getMessage());
		}
	}
	
	
	
	
	public void carregarMatriculaPorTurma() {
		
		try {
//			acao = FacesUtil.getParam("usuAcao");
//			String valor =FacesUtil.getParam("usuCod");

			if (turCod != null) {
				MatriculaDao matriculaDao = new MatriculaDao();
				listaMatriculas = matriculaDao.buscarPorTurma(turCod);

			} else {

				// listaMatriculas = new Matricula();
			}

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados da matricula:" + ex.getMessage());
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	public void rematricular(Ensino ensinoSelecionado) {
		
		AtividadeDao atividadeDao = new AtividadeDao();

		Atividade atividade = new Atividade();
		
		MatriculaDao matriculaDao = new MatriculaDao();

		Matricula matricula2 = new Matricula();
		
		Aluno aluno = new Aluno();
		AlunoDao alunoDao = new AlunoDao();
		
		
		
		matricula2 = matriculaDao.buscarPorAlunoEnsino(codigo, ensinoSelecionado.getIdEnsino());
		
		if (matricula2 != null) {
			String mat =matricula2.getStMatricula();
			
			if (mat.equalsIgnoreCase("Cancelada")) {

				matricula2.setStMatricula("Ativa");
				matriculaDao.editar(matricula2);

				FacesUtil.adicionarMsgInfo("A matrícula foi ativa novamente!");

				try {

				Date data = new Date();
				SimpleDateFormat formatado = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				data = new Date(formatado.format(data));
				
				Usuario usuario = new Usuario();

				usuario = autenticacaoBean.getUsuarioLogado();

				aluno = alunoDao.buscarPorCodigo(codigo);
				aluno.setSituacao("Matriculado");
				alunoDao.editar(aluno);

				aluno = alunoDao.buscarPorCodigo(codigo);
				
				atividade.setMatricula(matricula2);
				atividade.setAluno(aluno);
				atividade.setDtAtividade(data);
				atividade.setUsuario(usuario);
				atividade.setTipoAtividade("Rematrícula de aluno");

				atividadeDao.salvar(atividade);	
				
				}catch(RuntimeException ex) {
					FacesUtil.adicionarMsgErro("Erro ao rematricular!"+atividade);

				}
			}else {
				FacesUtil.adicionarMsgErro("A matrícula já está ativada!");
				
				
			}
		}
	
}
	
	
	
	
	public void carregarAluMatricula() {

		try {
//			acao = FacesUtil.getParam("usuAcao");
//			String valor =FacesUtil.getParam("usuCod");

			if (ensCod != null) {
				//MatriculaDao matriculaDao = new MatriculaDao();
				//listaMatriculas = matriculaDao.buscarPorEnsino(ensCod);
				CursoModuloDao cursoModuloDao = new CursoModuloDao();
				listaCursoModulos = cursoModuloDao.buscarPorChaveEnsino(ensCod);
				TurmaDao turmaDao = new TurmaDao();
				MatriculaDao matriculaDao = new MatriculaDao();
				
				for(int i=0;listaCursoModulos.size()>i;i++) {
				//listaCursoModulos.
				CursoModulo cursoModulo = new CursoModulo();
				cursoModulo=listaCursoModulos.get(i);	
				
				listaTurmas = turmaDao.buscarPorDisciplina(cursoModulo.getIdCursoModulo());
				
				Turma turma = new Turma();
				turma = listaTurmas.get(i);	
				listaMatriculas= matriculaDao.buscarPorTurma(turma.getIdTurma());
				
				
				}
				
				
			} else {

				// listaMatriculas = new Matricula();
			}

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados da matricula:" + ex.getMessage());
		}
	}
	
	

	public void cancelarMatricula() {

		MatriculaDao matriculaDao = new MatriculaDao();
		Matricula matricula = new Matricula();
		Aluno alun = new Aluno();
		AlunoDao alunoDa = new AlunoDao();
		
		
		try {
			String valor = FacesUtil.getParam("matCod");
			Long cod = Long.parseLong(valor);
		
			
			matricula = matriculaDao.buscarPorCodigo(cod);
			matricula.setStMatricula("Cancelada");
			matriculaDao.editar(matricula);

			FacesUtil.adicionarMsgInfo("Matrícula cancelada com sucesso!");

			try {

				Date data = new Date();
				SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				data = new Date(formatador.format(data));

				Aluno aluno = new Aluno();
				AlunoDao alunoDao = new AlunoDao();
				aluno = alunoDao.buscarPorCodigo(codigo);
				// aluno.setSituacao("Não matriculado");
				alunoDao.editar(aluno);

				aluno = alunoDao.buscarPorCodigo(codigo);

				Atividade atividade = new Atividade();
				AtividadeDao atividadeDao = new AtividadeDao();

				Usuario usuario = new Usuario();

				usuario = autenticacaoBean.getUsuarioLogado();

				atividade.setMatricula(matricula);
				atividade.setAluno(aluno);

				atividade.setDtAtividade(data);
				atividade.setUsuario(usuario);
				atividade.setTipoAtividade("Cancelamento de matrícula");

				atividadeDao.salvar(atividade);

			} catch (RuntimeException ex) {

				FacesUtil.adicionarMsgErro("Erro ao tentar cadastrar atividade:" + ex.getMessage());

			}

		} catch (RuntimeException er) {

			FacesUtil.adicionarMsgErro("Erro ao tentar cancelar a matrícula:" + er.getMessage());

		}

	}

	public void verificar() {

		MatriculaDao matriculaDao = new MatriculaDao();

		matricul = matriculaDao.buscarPorChave(codigo);

		// stMatricula = "Matriculado";

	}
	
	
	
	
	
	
	
	

	public void carregarCadastro() {

		try {
//			acao = FacesUtil.getParam("usuAcao");
//			String valor =FacesUtil.getParam("usuCod");

			if (codigo != null) {
				MatriculaDao matriculaDao = new MatriculaDao();
				listaMatriculas = matriculaDao.buscarPorChave(codigo);

			} else {

				// listaMatriculas = new Matricula();
			}

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados da matricula:" + ex.getMessage());
		}
	}

	public void carregarAlunoMatricula() {

		try {
//			acao = FacesUtil.getParam("usuAcao");
//			String valor =FacesUtil.getParam("usuCod");

			if (ensCod != null) {
				MatriculaDao matriculaDao = new MatriculaDao();
				listaMatriculas = matriculaDao.buscarPorEnsino(ensCod);
					
					
					
				
				
				
			} else {

				// listaMatriculas = new Matricula();
			}

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados da matricula:" + ex.getMessage());
		}
	}

}
