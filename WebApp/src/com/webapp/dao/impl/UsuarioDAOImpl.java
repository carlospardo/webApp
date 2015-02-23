package com.webapp.dao.impl;

import java.io.File;
import java.io.FileReader;

import com.csvreader.CsvReader;
import com.webapp.dao.UsuarioDAO;
import com.webapp.dto.UsuarioDTO;
import com.webapp.utiles.Constantes;

public class UsuarioDAOImpl implements UsuarioDAO{
	
	private String rutaApp;

	public UsuarioDAOImpl() {
		super();
		
	}
	/**
	 * Prepara el objeto UsuarioDAOImpl para poder ser utilizado.
	 * 
	 * @param rutaApp: path donde se encuentra el fichero donde se guarda la información de los usuarios
	 */
	public void inicializa(String rutaApp){
		this.rutaApp = rutaApp;
	}

	/**
	 * A partir del nombre del usuario, busca dicho usuario en la base de datos y devuelve un objeto UsuarioDTO con los datos del
	 * usuario. Si no existe el usuario devolverá null.
	 * 
	 * @param nombreUsuario: nombre del usuario
	 * @return UsuarioDTO
	 * @throws Exception
	 */
	public UsuarioDTO dameUsuarioPorNombre(String nombreUsuario) throws Exception{
		
			
		File fichero = new File(rutaApp + Constantes.REGISTRO.PATH);
		
		if(fichero != null && fichero.isFile() && fichero.canRead()){
			CsvReader reader = new CsvReader(new FileReader(fichero), ',');
			
			while (reader.readRecord())  {
				if(nombreUsuario.equalsIgnoreCase(reader.get(0).trim())){
					return new UsuarioDTO(reader.get(0).trim(), reader.get(1).trim()
							,reader.get(2).trim(),reader.get(3).trim(),reader.get(4).trim());
				}
			}
		}
		return null;
	}

	public String getRutaApp() {
		return rutaApp;
	}

	public void setRutaApp(String rutaApp) {
		this.rutaApp = rutaApp;
	}
}
