package com.webapp.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.webapp.bo.UsuarioBO;
import com.webapp.bo.impl.UsuarioBOImpl;
import com.webapp.dto.UsuarioDTO;
import com.webapp.servlet.Servlet;
import com.webapp.servlet.Servicio;
import com.webapp.utiles.Constantes;

import javax.servlet.RequestDispatcher;



public class Login  implements Servicio{

	UsuarioBO usuarioBO;
		
	private Logger log = Logger.getLogger(Login.class);
	
	public Login() {
		super();
		if(usuarioBO == null){
			usuarioBO = new UsuarioBOImpl();
		}
	}
	
	@Override
	public void inicializa(String rutaApp) {		
		usuarioBO.inicializa(rutaApp);		
	}

	public void ejecutaServicio(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String nombreUsuario = (String) request.getParameter("nombreUsuario");		
		String password = (String) request.getParameter("password");
		String pagina = (String) request.getParameter("pagina");
		String paginaDestino = null;
		
		log.info("Inicio servicio Login");
		
		
		UsuarioDTO usuario = usuarioBO.validaLogin(nombreUsuario, password);
		if(usuario != null){
			
			/*Guardamos el objeto usuario en la sesion para poder realizar comprovaciones cada vez que lanza una petición*/
			usuario.setPassword("");
			request.getSession().setAttribute("usuario", usuario);
		
			if (usuario.validaPermisos(pagina)){								
				paginaDestino = pagina;
			}
			else{
				String mensaje = "El usuario no tiene permisos para acceder a esta página";
				log.info(mensaje);
				request.setAttribute("mensaje", mensaje);
				
				paginaDestino = Constantes.PANTALLAS.ERROR;
			}
		}
		else{
			String mensaje = "El usuario no existe o la contraseña es incorrecta";
			log.info(mensaje);
			request.setAttribute("mensaje", mensaje);
			paginaDestino = Constantes.PANTALLAS.ERROR;
		}
		request.getRequestDispatcher(paginaDestino).forward(request, response);
		log.info("Fin servicio Login");
	}

	public UsuarioBO getUsuarioBO() {
		return usuarioBO;
	}

	public void setUsuarioBO(UsuarioBO usuarioBO) {
		this.usuarioBO = usuarioBO;
	}

	
	public boolean validaPermisos(HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*No hay ningun motivo aparente para que nadie no pueda acceder al servicio de login*/
		return true;
	}
}
