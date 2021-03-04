package br.com.sistema.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;

import br.com.sistema.dao.CadastroDao;
import br.com.sistema.dao.UsuarioDao;
import br.com.sistema.domain.Cadastro;
import br.com.sistema.domain.Usuario;
import br.com.sistema.util.FacesUtil;


@ManagedBean
public class CadastroBean {
	
	
	private Cadastro cadastro;
	private List<Cadastro> listaCadastros;// esse list terá todos os dados
	private List<Cadastro> listaCadastrosFiltrados;// esse list tera somente os filtrados
	
    @ManagedProperty(value="#{autenticacaoBean}")
    private AutenticacaoBean autenticacaoBean;
	
    
    public AutenticacaoBean getAutenticacaoBean() {
		return autenticacaoBean;
	}
    
    public void setAutenticacaoBean(AutenticacaoBean autenticacaoBean) {
		this.autenticacaoBean = autenticacaoBean;
	}
    
	private String acao;
	private Long codigo;
	
	
	public Cadastro getCadastro() {
		
		return cadastro;
	}
    
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
    
	public List<Cadastro> getListaCadastros() {
		return listaCadastros;
	}
    
	public void setListaCadastros(List<Cadastro> listaCadastros) {
		this.listaCadastros = listaCadastros;
	}

	
	public List<Cadastro> getListaCadastrosFiltrados() {
		return listaCadastrosFiltrados;
	}
	
	public void setListasFiltrados(List<Cadastro> listaCadastrosFiltrados) {
		this.listaCadastrosFiltrados = listaCadastrosFiltrados;
	}
	
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public void novo() {
		cadastro = new Cadastro();

	}

	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public void salvar() {
		Usuario usuario = new Usuario();
		Cadastro cadastr = new Cadastro();
		Date dat = new Date();
		
		try {
			
			Date data = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			//System.out.println(formatador.format(data));
			
			CadastroDao cadastroDao = new CadastroDao();
			UsuarioDao usuarioDao = new UsuarioDao();
			
			//usuario = usuarioDao.buscarPorCodigo(2L);
			
			//usuario = autenticacaoBean.getUsuarioLogado();
			usuario = autenticacaoBean.getUsuarioLogado();
			
			dat = new Date(formatador.format(data));
		
			cadastr.setDtCadastro(dat);
			cadastr.setUsuario(usuario);
			
			cadastroDao.salvar(cadastr);
			//cadastr = new Cadastro();
						
			//FacesUtil.adicionarMsgInfo("Cadastrado com sucesso!"+usuario);

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar realizar o cadastro!"+ex.getMessage());
		}
	}
	
	
//	public void excluir() {
//		try {
//			CadastroDao cadastroDao = new CadastroDao();
//			cadastroDao.excluir(cadastro);
//
//			FacesUtil.adicionarMsgInfo("Cadastro excluído com sucesso!");
//
//		} catch (RuntimeException ex) {
//			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar excluir o cadastro:" + ex.getMessage());
//		}
//	}
	
	
//	public void editar() {
//		try {
//			CadastroDao cadastroDao = new CadastroDao();
//			cadastroDao.editar(cadastro);
//
//			FacesUtil.adicionarMsgInfo("Cadastro editado com sucesso!");
//
//		} catch (RuntimeException ex) {
//			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar editar o cadastro:" + ex.getMessage());
//		}
//	}
	
	
	public void carregarPesquisa() {
		
		try {
			CadastroDao cadastroDao = new CadastroDao();
		    listaCadastros = cadastroDao.listar();


		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar listar os cadastros:" + ex.getMessage());
		}
	}
	
	
//	public void carregarCadastro() {
//	
//		try {
////			acao = FacesUtil.getParam("usuAcao");
////			String valor =FacesUtil.getParam("usuCod");
//				
//			if(codigo !=null) {
//				CadastroDao cadastroDao = new CadastroDao();
//				cadastro = cadastroDao.buscarPorCodigo(codigo);
//			}else {
//				
//				cadastro = new Cadastro();
//			}
//
//		} catch (RuntimeException ex) {
//			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados do cadastro:" + ex.getMessage());
//		}
//	}
//	
//
}
