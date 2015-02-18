package com.webapp.bo;

import com.webapp.dto.UsuarioDTO;

public interface UsuarioBO{
	
	public void inicializa(String rutaApp);
	
	public UsuarioDTO validaLogin(String nombre, String password) throws Exception;
	
}
