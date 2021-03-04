package br.com.sistema.domain;

import java.math.BigDecimal;
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

@Entity
@Table(name = "pagamento")
@NamedQueries({ @NamedQuery(name = "Pagamento.listar", query = "SELECT pagamento FROM Pagamento pagamento"),
@NamedQuery(name = "Pagamento.buscarPorCodigo", query = "SELECT pagamento FROM Pagamento pagamento WHERE pagamento.idPagamento = :idPagamento")	
})
public class Pagamento {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id_pagamento")
private Long idPagamento;

@Column(name = "valor", precision = 5, scale = 2, nullable = false)
private BigDecimal valor;

@Column(name = "forma_pagamento", nullable = false)
private String formaPagamento;

@Temporal(value = TemporalType.TIMESTAMP)
@Column(name = "data_cadastro", nullable = false)
private Date dataPagamento;


@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "alu_id_aluno", referencedColumnName = "id_aluno", nullable = false)
private Aluno aluno;

@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "cad_id_cadastro", referencedColumnName = "id_cadastro", nullable = false)
private Cadastro cadastro;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "mat_id_matricula", referencedColumnName = "id_matricula", nullable = false)
private Matricula matricula;

public Long getIdPagamento() {
	return idPagamento;
}

public void setIdPagamento(Long idPagamento) {
	this.idPagamento = idPagamento;
}

public BigDecimal getValor() {
	return valor;
}

public void setValor(BigDecimal valor) {
	this.valor = valor;
}

public String getFormaPagamento() {
	return formaPagamento;
}

public void setFormaPagamento(String formaPagamento) {
	this.formaPagamento = formaPagamento;
}

public Date getDataPagamento() {
	return dataPagamento;
}

public void setDataPagamento(Date dataPagamento) {
	this.dataPagamento = dataPagamento;
}

public Aluno getAluno() {
	return aluno;
}

public void setAluno(Aluno aluno) {
	this.aluno = aluno;
}

public Cadastro getCadastro() {
	return cadastro;
}

public void setCadastro(Cadastro cadastro) {
	this.cadastro = cadastro;
}

public Matricula getMatricula() {
	return matricula;
}

public void setMatricula(Matricula matricula) {
	this.matricula = matricula;
}

@Override
public String toString() {
	return "Pagamento [idPagamento=" + idPagamento + ", valor=" + valor + ", formaPagamento=" + formaPagamento
			+ ", dataPagamento=" + dataPagamento + ", aluno=" + aluno + ", cadastro=" + cadastro + ", matricula="
			+ matricula + "]";
}


}
