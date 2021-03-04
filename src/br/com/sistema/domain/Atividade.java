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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "atividade")
@NamedQueries({ @NamedQuery(name = "Atividade.listar", query = "SELECT atividade FROM Atividade atividade"),
@NamedQuery(name = "Atividade.buscarPorCodigo", query = "SELECT atividade FROM Atividade atividade WHERE atividade.usuario = :idUsuario")	
})

public class Atividade {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_atividade")
	private Long idAtividade;
	
	@Column(name = "tipo_atividade")
	private String tipoAtividade;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_atividade", nullable = false)
	private Date dtAtividade;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "alu_id_aluno", referencedColumnName = "id_aluno", nullable = true)
	private Aluno aluno;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mat_id_matricula", referencedColumnName = "id_matricula", nullable = true)
	private Matricula matricula;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pag_id_pagamento", referencedColumnName = "id_pagamento", nullable = true)
	private Pagamento pagamento;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario", nullable = false)
	private Usuario usuario ;

	
	
	
	public Long getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(Long idAtividade) {
		this.idAtividade = idAtividade;
	}

	public String getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(String tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public Date getDtAtividade() {
		return dtAtividade;
	}

	public void setDtAtividade(Date dtAtividade) {
		this.dtAtividade = dtAtividade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	
	
	
	@Override
	public String toString() {
		return "Atividade [idAtividade=" + idAtividade + ", tipoAtividade=" + tipoAtividade + ", dtAtividade="
				+ dtAtividade + ", aluno=" + aluno + ", matricula=" + matricula + ", pagamento=" + pagamento
				+ ", usuario=" + usuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAtividade == null) ? 0 : idAtividade.hashCode());
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
		Atividade other = (Atividade) obj;
		if (idAtividade == null) {
			if (other.idAtividade != null)
				return false;
		} else if (!idAtividade.equals(other.idAtividade))
			return false;
		return true;
	}
	
	
	

}
