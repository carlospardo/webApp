package com.webapp.servicios;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.servlet.Servicio;
import com.webapp.utiles.Constantes;

public class Logout implements Servicio{

	@Override
	public void inicializa(String rutaApp) {
	
	}

	@Override
	public void ejecutaServicio(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.getSession().setAttribute("usuario", null);
		
		request.getRequestDispatcher(Constantes.PANTALLAS.LOGIN).forward(request, response);

	}


}
