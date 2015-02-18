package com.webapp.dao;

import com.webapp.dto.UsuarioDTO;

public interface UsuarioDAO {

	public void inicializa(String rutaApp);
	public UsuarioDTO dameUsuarioPorNombre(String nombreUsuario) throws Exception;

}
