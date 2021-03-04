package br.com.sistema.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistema.dao.CadastroDao;
import br.com.sistema.dao.ProfessorDao;
import br.com.sistema.domain.Cadastro;
import br.com.sistema.domain.Professor;
import br.com.sistema.util.FacesUtil;


@ManagedBean
@ViewScoped
public class ProfessorBean {
	
	private Professor professorCadastro;
	private List<Professor> listaProfessores;// esse list terá todos os dados
	private List<Professor> listaProfessoresFiltrados;// esse list tera somente os filtrados
	
	private String acao;
	private Long codigo;
	
	
	public Professor getProfessorCadastro() {
		
		return professorCadastro;
	}
    
	public void setProfessorCadastro(Professor professorCadastro) {
		this.professorCadastro = professorCadastro;
	}
    
	public List<Professor> getListaProfessores() {
		return listaProfessores;
	}
    
	public void setListaProfessores(List<Professor> listaProfessores) {
		this.listaProfessores = listaProfessores;
	}

	
	public List<Professor> getListaProfessoresFiltrados() {
		return listaProfessoresFiltrados;
	}
	
	public void setListaProfessoresFiltrados(List<Professor> listaProfessoresFiltrados) {
		this.listaProfessoresFiltrados = listaProfessoresFiltrados;
	}
	
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public void novo() {
		professorCadastro = new Professor();

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
			
			
			ProfessorDao professorDao = new ProfessorDao();
			professorCadastro.setCadastro(cadastro);
			professorDao.salvar(professorCadastro);
			professorCadastro = new Professor();

			FacesUtil.adicionarMsgInfo("Professor salvo com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar salvar o professor:" + ex.getMessage());
		}
	}
	
	public void excluir() {
		try {
			ProfessorDao professorDao = new ProfessorDao();
			professorDao.excluir(professorCadastro);

			FacesUtil.adicionarMsgInfo("Professor excluído com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar excluir o professor:" + ex.getMessage());
		}
	}
	
	
	public void editar() {
		try {
			ProfessorDao professorDao = new ProfessorDao();
			professorDao.editar(professorCadastro);

			FacesUtil.adicionarMsgInfo("Professor editado com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar editar os dados do professor:" + ex.getMessage());
		}
	}
	
	
	public void carregarPesquisa() {
		
		try {
			ProfessorDao professorDao = new ProfessorDao();
		    listaProfessores = professorDao.listar();


		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar listar os professores:" + ex.getMessage());
		}
	}
	
	
	public void carregarCadastro() {
	
		try {
//			acao = FacesUtil.getParam("usuAcao");
//			String valor =FacesUtil.getParam("usuCod");
				
			if(codigo !=null) {
				ProfessorDao professorDao = new ProfessorDao();
				professorCadastro = professorDao.buscarPorCodigo(codigo);
			}else {
				
				professorCadastro = new Professor();
			}

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados do professor:" + ex.getMessage());
		}
	}

}