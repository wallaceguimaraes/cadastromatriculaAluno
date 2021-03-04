package br.com.sistema.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ensino")
@NamedQueries({ @NamedQuery(name = "Ensino.listar", query = "SELECT ensino FROM Ensino ensino"),
@NamedQuery(name = "Ensino.buscarPorCodigo", query = "SELECT ensino FROM Ensino ensino WHERE ensino.idEnsino = :idEnsino")
})
public class Ensino {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ensino")
	private Long idEnsino;
	
	@NotEmpty(message = "O campo nome do ensino é obrigatório!")
	@Column(name = "nome_ensino", length = 45, nullable = false)	
	private String nomeEnsino; 
	
	
	
	
	
	public Long getIdEnsino() {
		return idEnsino;
	}


	public void setIdEnsino(Long idEnsino) {
		this.idEnsino = idEnsino;
	}


	public String getNomeEnsino() {
		return nomeEnsino;
	}


	public void setNomeEnsino(String nomeEnsino) {
		this.nomeEnsino = nomeEnsino;
	}





	



	


	

	@Override
	public String toString() {
		return "Ensino [idEnsino=" + idEnsino + ", nomeEnsino=" + nomeEnsino + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEnsino == null) ? 0 : idEnsino.hashCode());
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
		Ensino other = (Ensino) obj;
		if (idEnsino == null) {
			if (other.idEnsino != null)
				return false;
		} else if (!idEnsino.equals(other.idEnsino))
			return false;
		return true;
	}
	
	
	
}
