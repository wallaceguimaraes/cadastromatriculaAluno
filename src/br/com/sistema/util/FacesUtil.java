package br.com.sistema.util;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class FacesUtil {

	public static void adicionarMsgInfo(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		FacesContext facescontext = FacesContext.getCurrentInstance();//captura o contexto corrente da parte da aplicação JSF
	facescontext.addMessage(null, facesMessage);
	}
	
	public static void adicionarMsgErro(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		FacesContext facescontext = FacesContext.getCurrentInstance();//captura o contexto da aplicação como um todo
		facescontext.addMessage(null, facesMessage);

	}
	

public static String getParam(String nome) {
	FacesContext facescontext = FacesContext.getCurrentInstance();
	
	ExternalContext externalContext = facescontext.getExternalContext();// contexto externo navegador
	Map<String, String> parametros =  externalContext.getRequestParameterMap();

	String valor = parametros.get(nome);
	
	return valor;
}


}
