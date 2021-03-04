package br.com.sistema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sistema.dao.ProfessorDao;
import br.com.sistema.domain.Professor;

@FacesConverter("professorConverter")
public class ProfessorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {//usado quando clica, pois seleciona o ID isso monta o objeto atraves do ID
		// TODO Auto-generated method stub
		try {
			Long codigo = Long.parseLong(valor);
			ProfessorDao professorDao = new ProfessorDao();
			Professor professor = professorDao.buscarPorCodigo(codigo);
			return professor;
			
		}catch(RuntimeException er) {
			
			return null;
		}
		
		
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {//recebe o objeto e retorna o ID
		// TODO Auto-generated method stub
	try {
			
		Professor professor = (Professor)objeto;
		Long codigo = professor.getIdProfessor();
		
		return codigo.toString();
		
		}catch(RuntimeException er) {
			
			return null;
		}
		
		
	}
	
}
