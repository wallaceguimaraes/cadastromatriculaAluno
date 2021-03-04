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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "turma")
@NamedQueries({ @NamedQuery(name = "Turma.listar", query = "SELECT turma FROM Turma turma"),
@NamedQuery(name = "Turma.buscarPorCodigo", query = "SELECT turma FROM Turma turma WHERE turma.idTurma = :idTurma"),
//@NamedQuery(name = "Turma.buscarPorChave", query = "SELECT turma FROM Turma turma WHERE turma.professor = :professor"),
@NamedQuery(name = "Turma.buscarUltimo", query = "SELECT turma FROM Turma turma ORDER BY turma.idTurma DESC"),
//@NamedQuery(name = "Turma.buscarPorDisciplina", query = "SELECT turma FROM Turma turma WHERE turma.curso = :curso"),
})
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_turma")
	private Long idTurma;
	
	
	
	@NotEmpty(message = "O campo horário início é obrigatório!")
	@Column(name = "nome_turma", length = 18, unique = true, nullable = false)	
	private String nomeTurma;
	
	
	@NotEmpty(message = "O campo data início é obrigatório!")
	@Column(name = "data_inicio", nullable = false)
	private String dtInicio;

	@NotEmpty(message = "O campo data fim é obrigatório!")
	@Column(name = "data_final", nullable = false)
	private String dtFinal;

	
	@Column(name = "qtd_vaga", length = 8, nullable = false)		
	private Long qtdVaga;
	
	
	@Column(name = "turno", length = 15, nullable = false)		
	private String turno;
	
	@Column(name = "periodo_letivo", length = 10, nullable = false)		
	private String periodoLetivo;

	@Column(name = "serie", length = 10, nullable = false)		
	private String serie;
	
	@NotNull(message = "A seleção do ensino é obrigatório!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ens_id_ensino", referencedColumnName = "id_ensino", nullable = false)
	private Ensino ensino;
	

//	@NotNull(message = "A seleção do professor é obrigatório!")
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "prof_id_professor", referencedColumnName = "id_professor", nullable = false)
//	private Professor professor;

	
//	@NotNull(message = "A seleção do curso é obrigatório!")
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "cur_id_curso_modulo", referencedColumnName = "id_curso_modulo", nullable = false)
//	private CursoModulo curso;
	
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "mat_id_matricula", referencedColumnName = "id_matricula", nullable = false)
//	private Matricula matricula;
	
	
	
	
	public Long getIdTurma() {
		return idTurma;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public String getPeriodoLetivo() {
		return periodoLetivo;
	}

	public void setPeriodoLetivo(String periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}

	public Ensino getEnsino() {
		return ensino;
	}

	public void setEnsino(Ensino ensino) {
		this.ensino = ensino;
	}

	
	
	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public String getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(String dtFinal) {
		this.dtFinal = dtFinal;
	}

	


//	public Professor getProfessor() {
//		return professor;
//	}
//
//	public void setProfessor(Professor professor) {
//		this.professor = professor;
//	}

//	public CursoModulo getCurso() {
//		return curso;
//	}
//
//	public void setCurso(CursoModulo curso) {
//		this.curso = curso;
//	}

	
	public String getCodTurma() {
		return nomeTurma;
	}

	public void setCodTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

//	public Matricula getMatricula() {
//		return matricula;
//	}
//
//	public void setMatricula(Matricula matricula) {
//		this.matricula = matricula;
//	}

	
	
	
	public Long getQtdVaga() {
		return qtdVaga;
	}

	public void setQtdVaga(Long qtdVaga) {
		this.qtdVaga = qtdVaga;
	}


	
	
	
	
	


	


	@Override
	public String toString() {
		return "Turma [idTurma=" + idTurma + ", nomeTurma=" + nomeTurma + ", dtInicio=" + dtInicio + ", dtFinal="
				+ dtFinal + ", qtdVaga=" + qtdVaga + ", turno=" + turno + ", periodoLetivo=" + periodoLetivo
				+ ", serie=" + serie + ", ensino=" + ensino + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTurma == null) ? 0 : idTurma.hashCode());
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
		Turma other = (Turma) obj;
		if (idTurma == null) {
			if (other.idTurma != null)
				return false;
		} else if (!idTurma.equals(other.idTurma))
			return false;
		return true;
	}

	

}
