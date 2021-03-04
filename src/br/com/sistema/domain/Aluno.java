package br.com.sistema.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "aluno")
@NamedQueries({ @NamedQuery(name = "Aluno.listar", query = "SELECT aluno FROM Aluno aluno"),
		@NamedQuery(name = "Aluno.buscarPorCodigo", query = "SELECT aluno FROM Aluno aluno WHERE aluno.idAluno = :idAluno"),
		@NamedQuery(name = "Aluno.buscarUltimo", query = "SELECT aluno FROM Aluno aluno ORDER BY aluno.idAluno DESC"), })
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_aluno")
	private Long idAluno;

	@NotEmpty(message = "O campo Nome do aluno é obrigatório!")
	@Size(min = 8, max = 45, message = "Tamanho inválido para o campo 'Nome do aluno'! Campo deve possuir (8 - 45) caracteres.")
	@Column(name = "nome_aluno", length = 50, nullable = false)
	private String nomeAluno;

	// @Temporal(value = TemporalType.DATE)
	@NotEmpty(message = "O campo Data de nascimento do aluno é obrigatório!")
	@Column(name = "data_nascimento")
	private String dtNascimento;

	@NotEmpty(message = "N° da identidade é obrigatório!")
	@Column(name = "n_identidade", length = 11, nullable = false, unique = true)
	private String nIdentidade;

	@NotEmpty(message = "O campo CPF é obrigatório!")
	@Column(name = "n_cpf", length = 15, nullable = false, unique = true)
	private String nCpf;

	@NotEmpty(message = "O campo de telefone 1 é obrigatório!")
	@Column(name = "telefone_1", length = 14, nullable = false)
	private String telefone1;

	@Column(name = "telefone_2", length = 14, nullable = true)
	private String telefone2;

	@NotEmpty(message = "O campo e-mail é obrigatório!")
	@Column(name = "email", length = 45, nullable = false)
	private String email;

	@NotEmpty(message = "O campo situação da matrícula é obrigatório!")
	@Column(name = "situacao", length = 25, nullable = false)
	private String situacao;
	
	
	
	@NotEmpty(message = "O campo naturalidade é obrigatório!")
	@Column(name = "naturalidade", length = 20, nullable = false)
	private String naturalidade;
	
	@NotEmpty(message = "O campo estado é obrigatório!")
	@Column(name = "estado", length = 20, nullable = false)
	private String estado;
	
	
	@NotEmpty(message = "O campo cidade é obrigatório!")
	@Column(name = "cidade", length = 20, nullable = false)
	private String cidade;
	
	
	@NotEmpty(message = "O campo bairro é obrigatório!")
	@Column(name = "bairro", length = 20, nullable = false)
	private String bairro;
	

	@NotEmpty(message = "O campo rua é obrigatório!")
	@Column(name = "rua", length = 20, nullable = false)
	private String rua;
	
	@Column(name = "complemento", length = 150, nullable = false)
	private String complemento;
	
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cad_id_cadastro_aluno", referencedColumnName = "id_cadastro", nullable = false)
	private Cadastro cadastro;

	
	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getnIdentidade() {
		return nIdentidade;
	}

	public void setnIdentidade(String nIdentidade) {
		this.nIdentidade = nIdentidade;
	}

	public String getnCpf() {
		return nCpf;
	}

	public void setnCpf(String nCpf) {
		this.nCpf = nCpf;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "Aluno [idAluno=" + idAluno + ", nomeAluno=" + nomeAluno + ", dtNascimento=" + dtNascimento
				+ ", nIdentidade=" + nIdentidade + ", nCpf=" + nCpf + ", telefone1=" + telefone1 + ", telefone2="
				+ telefone2 + ", email=" + email + ", situacao=" + situacao + ", naturalidade=" + naturalidade
				+ ", estado=" + estado + ", cidade=" + cidade + ", bairro=" + bairro + ", rua=" + rua + ", complemento="
				+ complemento + ", cadastro=" + cadastro + "]";
	}




}
