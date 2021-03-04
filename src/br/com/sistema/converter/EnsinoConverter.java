package br.com.sistema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sistema.dao.EnsinoDao;
import br.com.sistema.domain.Ensino;
import br.com.sistema.util.FacesUtil;

@FacesConverter("ensinoConverter")
public class EnsinoConverter implements Converter{
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {//usado quando clica, pois seleciona o ID isso monta o objeto atraves do ID
		// TODO Auto-generated method stub
		try {
			Long codigo = Long.parseLong(valor);
			EnsinoDao ensinoDao = new EnsinoDao();
			Ensino ensino = ensinoDao.buscarPorCodigo(codigo);

			return ensino;
			
		}catch(RuntimeException er) {
			
			return null;
		}
		
		
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {//recebe o objeto e retorna o ID
		// TODO Auto-generated method stub
	try {
			
		Ensino ensino = (Ensino)objeto;
		Long codigo = ensino.getIdEnsino();

		FacesUtil.adicionarMsgInfo("getAsString: "+codigo.toString());

		return codigo.toString();
		
		}catch(RuntimeException er) {
			
			return null;
		}
		
		
	}
	
	
	
	
}
