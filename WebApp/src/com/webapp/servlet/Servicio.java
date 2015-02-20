package com.webapp.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface Servicio {
	
	public void inicializa(String rutaApp);
	public void ejecutaServicio (HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public boolean validaPermisos (HttpServletRequest request, HttpServletResponse response) throws Exception;

}
