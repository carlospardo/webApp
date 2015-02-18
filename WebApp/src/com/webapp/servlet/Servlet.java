package com.webapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.webapp.utiles.Constantes;

public class Servlet extends HttpServlet {

	private Logger log = Logger.getLogger(Servlet.class);

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		
		
		String servicio = request.getParameter("servicio");
		log.info("Recibo petición, Servicio: " + servicio);
		
		String rutaApp = getServletContext().getRealPath("/");
		
		Servicio c1;
		try {
			
			c1 = Factory.getInstance().getServicio("com.webapp.servicios."+servicio, rutaApp);
			
			if(c1!=null){
				c1.ejecutaServicio(request, response);
				
			}else{	
				String mensaje = "Error no controlado";
				request.setAttribute ("mensaje",mensaje); 
				log.error("Envio mensaje de Error: " + mensaje);
				request.getRequestDispatcher(Constantes.PANTALLAS.ERROR).forward(request, response);		
			}
			
		}catch (Exception e) {
			log.error("Excepcion", e);
		}
	}
}
