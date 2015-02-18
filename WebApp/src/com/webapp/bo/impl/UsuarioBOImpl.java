package com.webapp.bo.impl;

import com.webapp.bo.UsuarioBO;
import com.webapp.dao.UsuarioDAO;
import com.webapp.dao.impl.UsuarioDAOImpl;
import com.webapp.dto.UsuarioDTO;
import com.webapp.utiles.StringUtiles;

public class UsuarioBOImpl implements UsuarioBO{

	private UsuarioDAO usuarioDAO;
	
	public UsuarioBOImpl() {
		if (usuarioDAO == null){
			setUsuarioDAO(new UsuarioDAOImpl());
		}
	}
	
	public void inicializa(String rutaApp){
		usuarioDAO.inicializa(rutaApp);
	}
	
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
