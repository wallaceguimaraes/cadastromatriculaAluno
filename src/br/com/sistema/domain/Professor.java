package br.com.sistema.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "professor")
@NamedQueries({ @NamedQuery(name = "Professor.listar", query = "SELECT professor FROM Professor professor"),
@NamedQuery(name = "Professor.buscarPorCodigo", query = "SELECT professor FROM Professor professor WHERE professor.idProfessor = :idProfessor")	
})
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_professor")
	private Long idProfessor;

	@NotEmpty(message = "O campo Nome completo do professor é obrigatório!")
	@Size(min = 5, max = 45 ,message = "Tamanho inválido para o campo 'Nome do professor'! Campo deve possuir (8 - 45) caracteres.")
	@Column(name = "nome_professor", length = 45, nullable = false)
	private String nomeProfessor;

	
	
	@CPF(message = "O campo CPF é obrigatório")
	@Column(name = "n_cpf", length = 15 ,unique = true, nullable = false)
	private String nCpf;

	
	@NotEmpty(message = "O campo de telefone 1 professor é obrigatório!")
	@Column(name = "telefone_1", length = 14,unique = true, nullable = false)
	private String telefone1;
	
	@NotEmpty(message = "O campo de telefone 2 do professor é obrigatório!")
	@Column(name = "telefone_2", length = 14,unique = true, nullable = false)
	private String telefone2;
	
	@Column(name = "email", length = 45,unique = true, nullable = false)
	private String email;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cad_id_cadastro_prof", referencedColumnName = "id_cadastro", nullable = false)
	private Cadastro cadastro;
	
	

	public Long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
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

	
	
	
	
	@Override
	public String toString() {
		return "Professor [idProfessor=" + idProfessor + ", nomeProfessor=" + nomeProfessor + ", nCpf=" + nCpf
				+ ", telefone1=" + telefone1 + ", telefone2=" + telefone2 + ", email=" + email + ", cadastro="
				+ cadastro + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProfessor == null) ? 0 : idProfessor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (idProfessor == null) {
			if (other.idProfessor != null)
				return false;
		} else if (!idProfessor.equals(other.idProfessor))
			return false;
		return true;
	}

	
	
	
	
}
