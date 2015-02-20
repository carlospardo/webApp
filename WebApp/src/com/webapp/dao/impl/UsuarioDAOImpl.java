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
	
	public void inicializa(String rutaApp){
		this.rutaApp = rutaApp;
	}

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
