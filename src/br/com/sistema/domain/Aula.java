package br.com.sistema.domain;

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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "aula")
@NamedQueries({ @NamedQuery(name = "Aula.listar", query = "SELECT aula FROM Aula aula"),
@NamedQuery(name = "Aula.buscarPorCodigo", query = "SELECT aula FROM Aula aula WHERE aula.idAula = :idAula"),
@NamedQuery(name = "Aula.buscarPorChave", query = "SELECT aula FROM Aula aula WHERE aula.turma = :turma")
})
public class Aula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_aula")
	private Long idAula;
	
	@Column(name = "dia", length = 8, nullable = false)	
	private String dia;
	
	

	@Column(name = "horario", length = 28, nullable = false)	
	private String horario;
	
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tur_id_turma", referencedColumnName = "id_turma", nullable = false)
	private Turma turma;



	public Long getIdAula() {
		return idAula;
	}



	public void setIdAula(Long idAula) {
		this.idAula = idAula;
	}



	public String getDia() {
		return dia;
	}



	public void setDia(String dia) {
		this.dia = dia;
	}



	public String getHorario() {
		return horario;
	}



	public void setHorario(String horario) {
		this.horario = horario;
	}



	public Turma getTurma() {
		return turma;
	}



	public void setTurma(Turma turma) {
		this.turma = turma;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAula == null) ? 0 : idAula.hashCode());
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
		Aula other = (Aula) obj;
		if (idAula == null) {
			if (other.idAula != null)
				return false;
		} else if (!idAula.equals(other.idAula))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Aula [idAula=" + idAula + ", dia=" + dia + ", horario=" + horario + ", turma=" + turma + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
