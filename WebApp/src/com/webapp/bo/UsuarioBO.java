package com.webapp.bo;

import com.webapp.dto.UsuarioDTO;

public interface UsuarioBO{
	
	/**Prepara el objeto UsuarioBOImpl para poder ser utilizado.
	 * 
	 * @param rutaApp: path donde se encuentra el fichero donde se guarda la información de los usuarios
	 */
	public void inicializa(String rutaApp);
	
	/** Validaaaa el login de un usuario accediendo a la base de datos. Si el login es correcto, devuelve un objeto UsuarioDTO con los datos
	 * del usuario.Si el usuario no existe o el passsword no es correcto, devuelve null.
	 *  
	 * @param nombre: nombre del usuario
	 * @param password: password del usuario
	 * @return UsuarioDTO
	 * @throws Exception
	 */
	public UsuarioDTO validaLogin(String nombre, String password) throws Exception;
	
}
