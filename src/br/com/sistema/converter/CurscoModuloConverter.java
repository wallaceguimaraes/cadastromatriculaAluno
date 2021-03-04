package br.com.sistema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sistema.dao.CursoModuloDao;
import br.com.sistema.domain.CursoModulo;
import br.com.sistema.util.FacesUtil;

@FacesConverter("cursoModuloConverter")
public class CurscoModuloConverter implements Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {//usado quando clica, pois seleciona o ID isso monta o objeto atraves do ID
		// TODO Auto-generated method stub
		try {
			Long codigo = Long.parseLong(valor);
			CursoModuloDao cursoModuloDao = new CursoModuloDao();
			CursoModulo cursoModulo = cursoModuloDao.buscarPorCodigo(codigo);

			return cursoModulo;
			
		}catch(RuntimeException er) {
			
			return null;
		}
		
		
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {//recebe o objeto e retorna o ID
		// TODO Auto-generated method stub
	try {
			
		CursoModulo cursoModulo = (CursoModulo)objeto;
		Long codigo = cursoModulo.getIdCursoModulo();

		FacesUtil.adicionarMsgInfo("getAsString: "+codigo.toString());

		return codigo.toString();
		
		}catch(RuntimeException er) {
			
			return null;
		}
		
		
	}
	
	
}
