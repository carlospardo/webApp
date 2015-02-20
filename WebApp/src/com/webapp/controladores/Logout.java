package com.webapp.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.webapp.servlet.Servicio;
import com.webapp.utiles.Constantes;

public class Logout implements Servicio{

	
	private Logger log = Logger.getLogger(Logout.class);
	
	@Override
	public void inicializa(String rutaApp) {
	
	}

	@Override
	public void ejecutaServicio(HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.info("Inicio servicio Logout");
		request.getSession().setAttribute("usuario", null);
		
		request.getRequestDispatcher(Constantes.PANTALLAS.LOGIN).forward(request, response);
		log.info("Fin servicio Logout");
	}
	
	public boolean validaPermisos(HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*No hay ningun motivo aparente para que nadie no pueda acceder al servicio de logout*/
		return true;
	}
}
