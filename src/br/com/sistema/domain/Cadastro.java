package br.com.sistema.domain;

import java.util.Date;

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

@Entity
@Table(name = "cadastro")
@NamedQueries({ @NamedQuery(name = "Cadastro.listar", query = "SELECT cadastro FROM Cadastro cadastro"),
@NamedQuery(name = "Cadastro.buscarPorCodigo", query = "SELECT cadastro FROM Cadastro cadastro WHERE cadastro.idCadastro = :idCadastro"),	
@NamedQuery(name = "Cadastro.buscarUltimo", query = "SELECT cadastro FROM Cadastro cadastro ORDER BY cadastro.idCadastro DESC"),	

})
public class Cadastro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cadastro")
	private Long idCadastro;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false)
	private Date dtCadastro;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario", nullable = false)
	private Usuario usuario;

	public Long getIdCadastro() {
		return idCadastro;
	}

	public void setIdCadastro(Long idCadastro) {
		this.idCadastro = idCadastro;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Cadastro [idCadastro=" + idCadastro + ", dtCadastro=" + dtCadastro + ", usuario=" + usuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCadastro == null) ? 0 : idCadastro.hashCode());
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
		Cadastro other = (Cadastro) obj;
		if (idCadastro == null) {
			if (other.idCadastro != null)
				return false;
		} else if (!idCadastro.equals(other.idCadastro))
			return false;
		return true;
	}

	
	
}
