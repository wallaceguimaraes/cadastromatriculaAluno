package br.com.sistema.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "usuario")
@NamedQueries({ @NamedQuery(name = "Usuario.listar", query = "SELECT usuario FROM Usuario usuario"),
@NamedQuery(name = "Usuario.buscarPorCodigo", query = "SELECT usuario FROM Usuario usuario WHERE usuario.idUsuario = :idUsuario"),
@NamedQuery(name = "Usuario.autenticar", query = "SELECT usuario FROM Usuario usuario WHERE usuario.login = :login AND usuario.senha = :senha AND usuario.stUsuario = 'Ativo'"),
})
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private Long idUsuario;

	@NotEmpty(message = "O campo Nome completo do usuário é obrigatório!")
	@Size(min = 5, max = 45 ,message = "Tamanho inválido para o campo 'Nome do usuário'! Campo deve possuir (8 - 45) caracteres.")
	@Column(name = "nome_usuario", length = 45, nullable = false)
	private String nomeUsuario;
	
	@NotEmpty(message = "O campo de login do usuário é obrigatório!")
	@Size(min = 4, max = 45 ,message = "Tamanho inválido para o campo 'Login'! Campo deve possuir (4 - 45) caracteres.")
	@Column(name = "login", length = 45, unique = true, nullable = false)
	private String login;
	
	@NotEmpty(message = "O campo senha é obrigatório!")
	@Size(min = 6, max = 45 ,message = "Tamanho inválido para o campo 'Senha'! Campo deve possuir (6 - 8) caracteres.")
	@Column(name = "senha", length = 32, nullable = false)
	private String senha;

	@Column(name = "email", length = 45, nullable = false)
	private String email;

	@NotEmpty(message = "O campo função é obrigatório!")
	@Column(name = "funcao_usuario", length = 45, nullable = false)
	private String funcaoUsuario;
	
	@NotEmpty(message = "O campo situação é obrigatório!")
	@Column(name = "st_usuario", length = 10, nullable = false)
	private String stUsuario;

	@NotEmpty(message = "O campo telefone é obrigatório!")
	@Column(name = "telefone", length = 14, nullable = false)
	private String telefone;
	
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFuncaoUsuario() {
		return funcaoUsuario;
	}

	public void setFuncaoUsuario(String funcaoUsuario) {
		this.funcaoUsuario = funcaoUsuario;
	}

	public String getStUsuario() {
		return stUsuario;
	}

	public void setStUsuario(String stUsuario) {
		this.stUsuario = stUsuario;
	}
	
	
	
	
	

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario + ", login=" + login + ", senha="
				+ senha + ", email=" + email + ", funcaoUsuario=" + funcaoUsuario + ", stUsuario=" + stUsuario
				+ ", telefone=" + telefone + "]";
	}



	
	
	

}
