package br.com.sistema.teste;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.sistema.dao.UsuarioDao;
import br.com.sistema.domain.Cadastro;
import br.com.sistema.domain.Usuario;

public class testeDao {
	
	

	Usuario usuario = new Usuario();
	UsuarioDao usuarioDao = new UsuarioDao();

//SALVAR	
//
//usuario.setNomeUsuario(request.getParameter("nome-usuario"));
//usuario.setLogin(request.getParameter("usuario"));
//usuario.setSenha(request.getParameter("senha-usuario"));
//usuario.setEmail(request.getParameter("email-usuario"));
//usuario.setFuncaoUsuario(request.getParameter("funcao-usuario"));
//	
//usuarioDao.salvar(usuario);	
//
//response.sendRedirect("NewFile.jsp");

//LISTAR

// List<Usuario> usuarios = usuarioDao.listar();
//  
//  for(Usuario usua : usuarios){
//	  
//	System.out.println(usua);  
//  }
//tambem pode listar pelo objeto
//  System.out.println(usuarios);		

//BUSCAR POR CODIGO

//	  Usuario usu = usuarioDao.buscarPorCodigo(1L);
//	  System.out.println(usu);

//EXCLUIR bucando

//	Usuario usua = usuarioDao.buscarPorCodigo(2L); 
//		if(usua !=null){
//		 usuarioDao.excluir(usua);
//		 }

//EXCLUIR
//excluir por codigo
//	usuarioDao.excluir(1L);

//EXCLUIR que vamos usar

//	UsuarioDao usuarioD = new UsuarioDao();
//	Usuario usu = usuarioD.buscarPorCodigo(2L);	
//	usuarioD.excluir(usu);

//EDITAR	

//	usuario.setIdUsuario(4L); //TRANSIENTE PQ NÃO ESTA NA SESSAO DO HIBERNATE
//	usuario.setNomeUsuario(request.getParameter("nome-usuario"));
//	usuario.setLogin(request.getParameter("usuario"));
//	usuario.setSenha(request.getParameter("senha-usuario"));
//	usuario.setEmail(request.getParameter("email-usuario"));
//	usuario.setFuncaoUsuario(request.getParameter("funcao-usuario"));
//		
//	usuarioDao.editar(usuario);

//EDITAR que vamos usar

//	usuario = usuarioDao.buscarPorCodigo(4L);	
//	
//	//usuario.setNomeUsuario(request.getParameter("nome-usuario"));
//	usuario.setLogin(request.getParameter("usuario"));
//	//usuario.setSenha(request.getParameter("senha-usuario"));
//	//usuario.setEmail(request.getParameter("email-usuario"));
//	//usuario.setFuncaoUsuario(request.getParameter("funcao-usuario"));
//	
//	usuarioDao.editar(usuario);

//	
//	HibernateUtil.getSessionFactory();
//	HibernateUtil.getSessionFactory().close();
//	

	//conversao bigdecimal new BigDecimal(100.90D)
	
//SALVAR COM CHAVE ESTRANGEIRA
	
//primeiro pesquisa a tabela com a chave estrangeira antes de inserir o cadastro

//	Date data = new Date(System.currentTimeMillis());
//	SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//	//System.out.println(formatador.format(data));
//	
//	UsuarioDao uDao = new UsuarioDao();
//	
//	Usuario usuarioPesquisado = uDao.buscarPorCodigo(1L);
//
//	Cadastro cadastro = new Cadastro();
//	
//	cadastro.set( new Date(formatador.format(data)));
//	cadastro.setUsuario(usuarioPesquisado);
//	
//	CadastroDao cDao = new CadastroDao();
//	cDao.salvar(cadastro);

	
	//BUSCAR POR CODIGO
	
//	CadastroDao cDao = new CadastroDao();
//	Cadastro cadastro = cDao.buscarPorCodigo(1L);
	
	
	//LISTAR
//	CadastroDao cDao = new CadastroDao();
//	List<Cadastro> cadastros = cDao.listar();
//	
//	System.out.println(cadastros);
	
	
	
	//Excluir cadastro por entidade
//	CadastroDao cDao= new CadastroDao();
//	Cadastro cadastro = cDao.buscarPorCodigo(1L);
//	
//	cDao.ecluir(cadastro);
	
	//EDITAR
	
//	Date data = new Date(System.currentTimeMillis());
//	SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//	
//	CadastroDao cDao = new CadastroDao();
//	Cadastro cadastro = cDao.buscarPorCodigo(4L);
//	cadastro.setDtCadastro(new Date(formatador.format(data)));
	
	////Long chave =Long.parseLong(cadastro.getUsuario().toString());//quando salvar aluno fazer essa busca e conversao
			
//	UsuarioDao uDao = new UsuarioDao();
//	Usuario usua = uDao.buscarPorCodigo(2L);
//	cadastro.setUsuario(usua);
//	cDao.editar(cadastro);

}
