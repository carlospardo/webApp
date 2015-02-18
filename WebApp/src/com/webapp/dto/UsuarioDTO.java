package com.webapp.dto;

import com.webapp.utiles.Constantes;

public class UsuarioDTO {

	private String nombre;
	private String password;
	private String rolPag1;
	private String rolPag2;
	private String rolPag3;

	
	public UsuarioDTO() {
		super();		
	}
	
	public UsuarioDTO(String nombre, String password){
		super();
		this.nombre = nombre;
		this.password = password;
	}
	
	public UsuarioDTO(String nombre, String password, String rolPag1,
			String rolPag2, String rolPag3) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.rolPag1 = rolPag1;
		this.rolPag2 = rolPag2;
		this.rolPag3 = rolPag3;
	}
	
	public boolean validaPermisos(String pagina){
		if(Constantes.PANTALLAS.PAGINA_1.equals(pagina)){
			return rolPag1.equals("S") ? true : false;
		}
		else if(Constantes.PANTALLAS.PAGINA_2.equals(pagina)){
			return rolPag2.equals("S") ? true : false;
		}
		else if(Constantes.PANTALLAS.PAGINA_3.equals(pagina)){
			return rolPag3.equals("S") ? true : false;
		}
		return false;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRolPag1() {
		return rolPag1;
	}

	public void setRolPag1(String rolPag1) {
		this.rolPag1 = rolPag1;
	}

	public String getRolPag2() {
		return rolPag2;
	}

	public void setRolPag2(String rolPag2) {
		this.rolPag2 = rolPag2;
	}

	public String getRolPag3() {
		return rolPag3;
	}

	public void setRolPag3(String rolPag3) {
		this.rolPag3 = rolPag3;
	}
	
}
