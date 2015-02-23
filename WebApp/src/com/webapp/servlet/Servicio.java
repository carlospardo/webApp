package com.webapp.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface Servicio {
	
	/**
	 * Prepara el objeto para poder ser utilizado.
	 * @param rutaApp: path donde se encuentra el fichero donde se guarda la información de los usuarios
	 */
	public void inicializa(String rutaApp);
	
	/**
	 * Ejecuta el servicio solicitado.
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void ejecutaServicio (HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	/**
	 * Permite validar si el usuario tiene permisos para acceder al servicio solicitado.
	 * 
	 * @param request
	 * @param response
	 * @return boolean
	 * @throws Exception
	 */
	public boolean validaPermisos (HttpServletRequest request, HttpServletResponse response) throws Exception;

}
