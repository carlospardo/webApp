package com.webapp.utiles;

public class StringUtiles {

	public static boolean notNull(String valor){
		if(valor == null || "".equals(valor))
			return false;
		
		return true;
	}
	
	public static boolean nullOrEmpty(String valor){
		if(valor == null || "".equals(valor))
			return true;
		
		return false;
	}
}
