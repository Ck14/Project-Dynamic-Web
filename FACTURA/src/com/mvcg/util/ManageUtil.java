package com.mvcg.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ManageUtil {
	
	public void agregarMensaje(String mensaje) {
		FacesMessage messaje = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, null);
		FacesContext.getCurrentInstance().addMessage(null, messaje);
	}
	
	

}
