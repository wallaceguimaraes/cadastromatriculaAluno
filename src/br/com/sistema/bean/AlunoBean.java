package br.com.sistema.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.sistema.dao.AlunoDao;
import br.com.sistema.dao.AtividadeDao;
import br.com.sistema.dao.CadastroDao;
import br.com.sistema.dao.UsuarioDao;
import br.com.sistema.domain.Aluno;
import br.com.sistema.domain.Atividade;
import br.com.sistema.domain.Cadastro;
import br.com.sistema.domain.Usuario;
import br.com.sistema.util.FacesUtil;

@ManagedBean
@ViewScoped
public class AlunoBean {

	private Aluno alunoCadastro;
	private List<Aluno> listaAlunos;// esse list terá todos os dados
	private List<Aluno> listaAlunosFiltrados;// esse list tera somente os filtrados
	private String acao;
	private Long codigo;
	
	 @ManagedProperty(value="#{autenticacaoBean}")
	    private AutenticacaoBean autenticacaoBean;

	 
	public AutenticacaoBean getAutenticacaoBean() {
		return autenticacaoBean;
	}

	public void setAutenticacaoBean(AutenticacaoBean autenticacaoBean) {
		this.autenticacaoBean = autenticacaoBean;
	}

	public Aluno getAlunoCadastro() {
		return alunoCadastro;
	}

	public void setAlunoCadastro(Aluno alunoCadastro) {
		this.alunoCadastro = alunoCadastro;
	}

	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public void setListaAlunos(List<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}

	public List<Aluno> getListaAlunosFiltrados() {
		return listaAlunosFiltrados;
	}

	public void setListaAlunosFiltrados(List<Aluno> listaAlunosFiltrados) {
		this.listaAlunosFiltrados = listaAlunosFiltrados;
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

	public void novo() {
		alunoCadastro = new Aluno();

	}

	public void salvar() {

		try {
			
			
			
			Cadastro cadastro = new Cadastro();
			CadastroDao cadastroDao = new CadastroDao();

			cadastro = cadastroDao.buscarUltimo();
			AlunoDao alunoDao = new AlunoDao();
			alunoCadastro.setCadastro(cadastro);
			alunoDao.salvar(alunoCadastro);
			
			
			alunoCadastro = new Aluno();

			FacesUtil.adicionarMsgInfo("Aluno salvo com sucesso!");

			Atividade atividade = new Atividade();

			try {

				Usuario usuario = new Usuario();
				UsuarioDao usuarioDao = new UsuarioDao();
				
				AtividadeDao atividadeDao = new AtividadeDao();

				Aluno aluno = new Aluno();
				AlunoDao aluDao = new AlunoDao();
				
				
				Date dat = new Date();
				Date data = new Date();
				SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				// buscar o usuario
				//usuario = usuarioDao.buscarPorCodigo(2L);
				usuario = autenticacaoBean.getUsuarioLogado();
				
				dat = new Date(formatador.format(data));

				aluno = aluDao.buscarUltimo();
				
				atividade.setAluno(aluno);
				atividade.setDtAtividade(dat);
				atividade.setUsuario(usuario);
				atividade.setTipoAtividade("Cadastro de aluno");
				atividade.setAluno(aluno);
				
				
				atividadeDao.salvar(atividade);

				
			} catch (RuntimeException er) {
				FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar salvar a atividade:" +atividade);

			}

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar salvar o aluno:" + ex.getMessage());
		}
	}

	public void excluir() {
		try {
			AlunoDao alunoDao = new AlunoDao();
			alunoDao.excluir(alunoCadastro);

			FacesUtil.adicionarMsgInfo("Aluno excluído com sucesso!");
			
			Atividade atividade = new Atividade();			
			
			try {

				Usuario usuario = new Usuario();
				UsuarioDao usuarioDao = new UsuarioDao();
				
				AtividadeDao atividadeDao = new AtividadeDao();

				Aluno aluno = new Aluno();
				AlunoDao aluDao = new AlunoDao();
				
				Date dat = new Date();
				Date data = new Date();
				SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				// buscar o usuario
				
				usuario = autenticacaoBean.getUsuarioLogado();

				
				dat = new Date(formatador.format(data));

				aluno = aluDao.buscarUltimo();
				
				atividade.setAluno(aluno);
				atividade.setDtAtividade(dat);
				atividade.setUsuario(usuario);
				atividade.setTipoAtividade("Exclusão de aluno");
				atividade.setAluno(aluno);
				
				
				atividadeDao.salvar(atividade);

				
			} catch (RuntimeException er) {
				FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar salvar a atividade:" +atividade);

			}
			
			
			

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar excluir o aluno:" + ex.getMessage());
		}
	}

	public void editar() {
		try {
			AlunoDao alunoDao = new AlunoDao();
			alunoDao.editar(alunoCadastro);

			FacesUtil.adicionarMsgInfo("Aluno editado com sucesso!");

			
			
           Atividade atividade = new Atividade();			
			
			try {

				Usuario usuario = new Usuario();
				UsuarioDao usuarioDao = new UsuarioDao();
				
				AtividadeDao atividadeDao = new AtividadeDao();

				Aluno aluno = new Aluno();
				AlunoDao aluDao = new AlunoDao();
				
				Date dat = new Date();
				Date data = new Date();
				SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				// buscar o usuario

				usuario = autenticacaoBean.getUsuarioLogado();

				
				dat = new Date(formatador.format(data));

				aluno = aluDao.buscarUltimo();
				
				atividade.setAluno(aluno);
				atividade.setDtAtividade(dat);
				atividade.setUsuario(usuario);
				atividade.setTipoAtividade("Edição de aluno");
				atividade.setAluno(aluno);
				
				
				atividadeDao.salvar(atividade);

				
			} catch (RuntimeException er) {
				FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar salvar a atividade:" +atividade);

			}
			
			
			
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar editar os dados do aluno:" + ex.getMessage());
		}
	}

	public void carregarPesquisa() {

		try {
			AlunoDao alunoDao = new AlunoDao();
			listaAlunos = alunoDao.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar listar os alunos:" + ex.getMessage());
		}
	}

	public void carregarCadastro() {

		try {
//		acao = FacesUtil.getParam("usuAcao");
//		String valor =FacesUtil.getParam("usuCod");

			if (codigo != null) {
				AlunoDao alunoDao = new AlunoDao();
				alunoCadastro = alunoDao.buscarPorCodigo(codigo);
			} else {

				alunoCadastro = new Aluno();
			}

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados do aluno:" + ex.getMessage());
		}
	}

}
