package com.webapp.servlet;

import java.util.Hashtable;

/**
 * Implementa los patrones de diseño Factory y Singletton. El primero permite obtener un objeto Java
 * que hace referencia a una clase existente solo con pasarle el nombre de dicha clase. El segundo 
 * permite garantizar que una clase solo tenga una instancia y proporciona un punto de acceso global
 * a ella.
 * 
 * @author Carlos
 *
 */
public class Factory {

	private static Factory INSTANCE = null;
	private Hashtable <String, Servicio> h = null;
	
	
	private Factory() {
		this.h = new Hashtable <String, Servicio> ();
	}
	
	public static  Factory getInstance() 
    {
        if (INSTANCE == null)
        {
        	INSTANCE = new Factory();
        }
        return INSTANCE;
    }	
	
	/**
	 * Permite obtener una instancia única a la clase cuyo nombre se pasa por parametro
	 * @param comando Nombre de la clase
	 * @param rutaApp path donde se aloja la aplicación en el servidor
	 * @return Instancia a la clase
	 * 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public Servicio getServicio(String comando, String rutaApp) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Servicio c = h.get(comando);
		if (c==null){
			c = (Servicio) (Class.forName(comando).newInstance());
			c.inicializa(rutaApp);
			h.put(comando, c);
		}
		return c;
	}

}
