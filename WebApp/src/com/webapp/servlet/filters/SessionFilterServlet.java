package com.webapp.servlet.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.webapp.dto.UsuarioDTO;
import com.webapp.utiles.Constantes;
import com.webapp.utiles.StringUtiles;

public class SessionFilterServlet implements Filter {

	private Logger log = Logger.getLogger(SessionFilterServlet.class);

	private String paginaLogin = null;
	private String paginaError = null;

	public void destroy() {

	}

	public void init(FilterConfig config) throws ServletException {
		paginaLogin = config.getInitParameter("paginaLogin");
		paginaError = config.getInitParameter("paginaError");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException {

		
		try {
			HttpSession sesion = null;
			String uri = null;
			String servicio = null;
			String pagina = null;
			String path = null;
			
			if (request != null && request instanceof HttpServletRequest) {				
				sesion = ((HttpServletRequest) request).getSession();
				uri = ((HttpServletRequest) request).getRequestURI();
				path = ((HttpServletRequest) request).getContextPath() + "/";
				servicio = request.getParameter("servicio");
				pagina = request.getParameter("pagina");
				log.info("CONTROL DE SESION: Servicio solicitado: " + servicio);
			}
			
			UsuarioDTO usuario = null;

			if (sesion != null) usuario = (UsuarioDTO) sesion.getAttribute("usuario");
		
			/*Si no hay sesion o uri, redirigimos a la pagina de login*/
			if(sesion == null || uri == null){
				log.info("CONTROL DE SESION: Redirigiendo. La sesion ha expirado o no existe y no se est� iniciando sesi�n");						
				((HttpServletResponse)response).sendRedirect(path);
			}
			
			/*Si se quiere acceder a la pagina de login, se va a mostrar un error o estamos iniciando o cerrando sesi�n no redirigimos*/
			else if(uri.contains(paginaLogin) || uri.contains(paginaError)
					|| uri.equals(path)
					|| Constantes.SERVICIOS.LOGIN.equals(servicio)
					|| Constantes.SERVICIOS.LOGOUT.equals(servicio)){
				chain.doFilter(request, response);
			}
			/*Si la sesion a expirado o el usuario no tiene permisos para acceder a la pagina, redirigimos a la pagina de login*/
			else if(usuario == null || sesion.isNew() || pagina == null
					|| !usuario.validaPermisos(pagina)){
				log.info("CONTROL DE SESION: Redirigiendo. La sesion ha expirado o no existe y no se est� iniciando sesi�n");			
				((HttpServletResponse)response).sendRedirect(path);
			}				
			else{
				chain.doFilter(request, response);	
			}

			
			
//			/*Si la sesion es nueva (o a caducado) redirigimos a la p�gina de login siempre y cuando no se est� accediendo ya o se est� llamando 
//			 * al servicio de logeo*/			
//			if (sesion == null || uri == null 
//			|| ((usuario == null || sesion.isNew()) 
//					&& !uri.contains(paginaLogin) && !uri.contains(paginaError)
//					&& !Constantes.SERVICIOS.LOGIN.equals(servicio))) {
//				log.info("CONTROL DE SESION: Redirigiendo. La sesion ha expirado o no existe y no se est� iniciando sesi�n");			
////				request.getRequestDispatcher(path + Constantes.PANTALLAS.LOGIN).forward(request, response);
//				
//				((HttpServletResponse)response).sendRedirect(path + Constantes.PANTALLAS.LOGIN);
//				
//			}
//			else{
//				/*Si el usuario no tiene permisos para acceder a la pagina solicitada, redirigimos a la pantalla de error*/
//				if(usuario == null || pagina == null && !uri.contains(paginaLogin) && !uri.contains(paginaError) && !usuario.validaPermisos(pagina))){					
//					log.info("CONTROL DE SESION: Redirigiendo. El usuario no tiene permisos para acceder a esta p�gina");
//					request.setAttribute("mensaje","Error: el usuario no tiene permisos para acceder a esta p�gina");
//					
////					request.getRequestDispatcher(paginaError).forward(request, response);
//					
//					
//					((HttpServletResponse)response).sendRedirect(path + Constantes.PANTALLAS.ERROR);
//				}
//				else{
//					chain.doFilter(request, response);
//				}
//			}

		} catch (Exception ex) {
			log.error("CONTROL DE SESION: Error al redirigir a" + paginaLogin, ex);
			throw new ServletException(
					"CONTROL DE SESION: Error al redirigir a " + paginaLogin + ". Error: " + ex.getMessage());
		}

	}

}
