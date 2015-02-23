package com.webapp.utiles;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

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
	
	/**
	 * Devuelve el valor hash del String pasado por parámetro. 
	 * @param texto
	 * @return String
	 * @throws Exception
	 */
	public static String dameHash(String texto) throws Exception {
 
        MessageDigest md = MessageDigest.getInstance("MD5");  
        byte[] messageDigest = md.digest(texto.getBytes());  
        BigInteger num = new BigInteger(1, messageDigest);  
        String textoEnriptado = num.toString(16);  
        while (textoEnriptado.length() < 32) {  
            textoEnriptado = "0" + textoEnriptado;  
        }  
        return textoEnriptado;  
    }

}
