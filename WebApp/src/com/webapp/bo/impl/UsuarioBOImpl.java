package com.webapp.bo.impl;

import com.webapp.bo.UsuarioBO;
import com.webapp.dao.UsuarioDAO;
import com.webapp.dao.impl.UsuarioDAOImpl;
import com.webapp.dto.UsuarioDTO;
import com.webapp.utiles.StringUtiles;

public class UsuarioBOImpl implements UsuarioBO{

	private UsuarioDAO usuarioDAO;
	
	public UsuarioBOImpl() {
		/*Al inicializar el objeto UsuarioBOImpl inicializamos también el objeto UsuarioDAOImpl*/
		if (usuarioDAO == null){
			setUsuarioDAO(new UsuarioDAOImpl());
		}
	}
	
	/**
	 * Prepara el objeto UsuarioBOImpl para poder ser utilizado.
	 * 
	 * @param rutaApp: path donde se encuentra el fichero donde se guarda la información de los usuarios
	 */
	public void inicializa(String rutaApp){
		usuarioDAO.inicializa(rutaApp);
	}
	
	/** Valida el login de un usuario accediendo a la base de datos. Si el login es correcto, devuelve un objeto UsuarioDTO con los datos
	 * del usuario.Si el usuario no existe o el passsword no es correcto, devuelve null.
	 *  
	 * @param nombre: nombre del usuario
	 * @param password: password del usuario
	 * @return UsuarioDTO
	 * @throws Exception
	 */
	public UsuarioDTO validaLogin(String nombre, String password) throws Exception {
		
		if (StringUtiles.notNull(nombre) && StringUtiles.notNull(password)){
			UsuarioDTO usuarioBD = usuarioDAO.dameUsuarioPorNombre(nombre);	
			
			if(usuarioBD != null && usuarioBD.getPassword().equalsIgnoreCase(password)){				
				return usuarioBD;
			}			
		}
		return null;
	}


	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
}
