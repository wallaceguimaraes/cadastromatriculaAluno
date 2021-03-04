package br.com.sistema.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistema.dao.CadastroDao;
import br.com.sistema.dao.ProfessorDao;
import br.com.sistema.domain.Cadastro;
import br.com.sistema.domain.Professor;
import br.com.sistema.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ServicosBean {

	private Professor servicosProfessor;
	
	
	
	
	public Professor getServicosProfessor() {
		return servicosProfessor;
	}




	public void setServicosProfessor(Professor servicosProfessor) {
		this.servicosProfessor = servicosProfessor;
	}




	public void CadastrarProfessor() {
		
		try {
		CadastroBean cadastroBean = new CadastroBean();
		
		ProfessorDao professorDao = new ProfessorDao();
	
		Cadastro cadastro = new Cadastro();
		CadastroDao cadastroDao = new CadastroDao();
		
		cadastroBean.salvar();
		
		cadastro = cadastroDao.buscarUltimo();
		
		servicosProfessor.setCadastro(cadastro);
		professorDao.salvar(servicosProfessor);
		servicosProfessor = new Professor();
		
		}catch(RuntimeException er) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar salvar o professor:" + er.getMessage());

		}
		
		
		
		
		
	}
	
	
	
	
}
