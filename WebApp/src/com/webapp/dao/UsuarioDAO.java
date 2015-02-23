package com.webapp.dao;

import com.webapp.dto.UsuarioDTO;

public interface UsuarioDAO {

	/**
	 * Prepara el objeto UsuarioDAOImpl para poder ser utilizado.
	 * 
	 * @param rutaApp: path donde se encuentra el fichero donde se guarda la información de los usuarios
	 */
	public void inicializa(String rutaApp);
	
	/**
	 * A partir del nombre del usuario, busca dicho usuario en la base de datos y devuelve un objeto UsuarioDTO con los datos del
	 * usuario. Si no existe el usuario devolverá null.
	 * 
	 * @param nombreUsuario: nombre del usuario
	 * @return UsuarioDTO
	 * @throws Exception
	 */
	public UsuarioDTO dameUsuarioPorNombre(String nombreUsuario) throws Exception;

}
