package br.com.sistema.domain;

import java.math.BigDecimal;

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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cursomodulo")
@NamedQueries({ @NamedQuery(name = "CursoModulo.listar", query = "SELECT cursomodulo FROM CursoModulo cursomodulo"),
@NamedQuery(name = "CursoModulo.buscarPorCodigo", query = "SELECT cursomodulo FROM CursoModulo cursomodulo WHERE cursomodulo.idCursoModulo = :idCursoModulo"),	
//@NamedQuery(name = "CursoModulo.buscarPorChaveEnsino", query = "SELECT cursomodulo FROM CursoModulo cursomodulo WHERE cursomodulo.ensino = :ensino")	
})
public class CursoModulo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_curso_modulo")
	private Long idCursoModulo;

	@NotEmpty(message = "Nome do curso é obrigatório!")
	@Size(min = 8, max = 45 ,message = "Tamanho inválido para o campo 'Nome do curso!' Campo deve possuir (8 - 45) caracteres.")
	@Column(name = "nome_curso", length = 45, nullable = false)
	private String nomeCurso;

	@NotNull(message = "Carga horária é obrigatória!")
	@Column(name = "carga_horaria", length = 4, nullable = false)
	private Integer cargaHoraria;

	
	@NotNull(message = "O campo 'Valor do curso' é obrigatório!")
	@DecimalMin(value ="0.1" , message = "Informe um valor maior do que zero!")
	@DecimalMax(value ="999.99", message = "Informe um valor menor ou igual a 999.99 para o valor do curso!")
	@Column(name = "valor_curso", precision = 5, scale = 2, nullable = false)
	private BigDecimal valorCurso;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cad_id_cadastro_curso", referencedColumnName = "id_cadastro", nullable = false)
	private Cadastro cadastro;

	
	
	
	
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "ens_id_ensino", referencedColumnName = "id_ensino", nullable = false)
//	private Ensino ensino;
//	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tur_id_turma", referencedColumnName = "id_turma", nullable = false)
	private Turma turma;
	
	
	@NotNull(message = "A seleção do professor é obrigatório!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prof_id_professor", referencedColumnName = "id_professor", nullable = false)
	private Professor professor;
	
//
//	public Ensino getEnsino() {
//		return ensino;
//	}
//
//	public void setEnsino(Ensino ensino) {
//		this.ensino = ensino;
//	}

	public Long getIdCursoModulo() {
		return idCursoModulo;
	}

	public void setIdCursoModulo(Long idCurso) {
		this.idCursoModulo = idCursoModulo;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public BigDecimal getValorCurso() {
		return valorCurso;
	}

	public void setValorCurso(BigDecimal valorCurso) {
		this.valorCurso = valorCurso;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	
	
	
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	



	@Override
	public String toString() {
		return "CursoModulo [idCursoModulo=" + idCursoModulo + ", nomeCurso=" + nomeCurso + ", cargaHoraria="
				+ cargaHoraria + ", valorCurso=" + valorCurso + ", cadastro=" + cadastro + ", turma=" + turma
				+ ", professor=" + professor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCursoModulo == null) ? 0 : idCursoModulo.hashCode());
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
		CursoModulo other = (CursoModulo) obj;
		if (idCursoModulo == null) {
			if (other.idCursoModulo != null)
				return false;
		} else if (!idCursoModulo.equals(other.idCursoModulo))
			return false;
		return true;
	}



}
