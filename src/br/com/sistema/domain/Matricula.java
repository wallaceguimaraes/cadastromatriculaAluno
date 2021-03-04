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


@Entity
@Table(name = "matricula")
@NamedQueries({ @NamedQuery(name = "Matricula.listar", query = "SELECT matricula FROM Matricula matricula"),
@NamedQuery(name = "Matricula.buscarPorCodigo", query = "SELECT matricula FROM Matricula matricula WHERE matricula.idMatricula = :idMatricula"),
@NamedQuery(name = "Matricula.buscarUltimo", query = "SELECT matricula FROM Matricula matricula ORDER BY matricula.idMatricula DESC"),	
@NamedQuery(name = "Matricula.buscarPorChave", query = "SELECT matricula FROM Matricula matricula WHERE matricula.aluno = :aluno"),
@NamedQuery(name = "Matricula.buscarPorAlunoTurma", query = "SELECT matricula FROM Matricula matricula WHERE matricula.aluno = :aluno and matricula.turma = :turma"),
@NamedQuery(name = "Matricula.buscarPorTurma", query = "SELECT matricula FROM Matricula matricula WHERE matricula.turma = :turma"),
//@NamedQuery(name = "Matricula.buscarPorAlunoEnsino", query = "SELECT matricula FROM Matricula matricula WHERE matricula.aluno = :aluno and matricula.ensino = :ensino"),
//@NamedQuery(name = "Matricula.buscarPorEnsino", query = "SELECT matricula FROM Matricula matricula WHERE matricula.ensino = :ensino")
})
public class Matricula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_matricula")
	private Long idMatricula;
	
	@Column(name = "n_matricula", length = 12, nullable = false, unique = true)
	private Integer numeroMatricula;
	
	@Column(name = "st_matricula",length = 10, nullable = false)
	private String stMatricula;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_matricula", nullable = false)
	private Date dataMatricula;
	
	@Column(name = "n_parcela", nullable = false)	
	private  Long nParcelas; 

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tur_id_turma", referencedColumnName = "id_turma", nullable = false)
	private Turma turma;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "alu_id_aluno", referencedColumnName = "id_aluno", nullable = false)
	private Aluno aluno;


	
	
	
	public Long getIdMatricula() {
		return idMatricula;
	}


	public void setIdMatricula(Long idMatricula) {
		this.idMatricula = idMatricula;
	}


	public Integer getNumeroMatricula() {
		return numeroMatricula;
	}


	public void setNumeroMatricula(Integer numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}


	public String getStMatricula() {
		return stMatricula;
	}


	public void setStMatricula(String stMatricula) {
		this.stMatricula = stMatricula;
	}


	public Date getDataMatricula() {
		return dataMatricula;
	}


	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}


	public Turma getTurma() {
		return turma;
	}


	public void setTurma(Turma turma) {
		this.turma = turma;
	}


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	
	
	
	
//	public Ensino getEnsino() {
//		return ensino;
//	}
//
//
//	public void setEnsino(Ensino ensino) {
//		this.ensino = ensino;
//	}


	public Long getnParcelas() {
		return nParcelas;
	}
	
	public void setnParcelas(Long nParcelas) {
		this.nParcelas = nParcelas;
	}


	@Override
	public String toString() {
		return "Matricula [idMatricula=" + idMatricula + ", numeroMatricula=" + numeroMatricula + ", stMatricula="
				+ stMatricula + ", dataMatricula=" + dataMatricula + ", nParcelas=" + nParcelas + ", turma=" + turma
				+ ", aluno=" + aluno + "]";
	}


	



	
		
	
}
