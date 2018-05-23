package org.proxibanqueV4.spring.exception;

public class DecouvertException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public DecouvertException() {
		super("Aucun virement possible en dessous du découvert autorisé. Le découvert autorisé pour un compte courant est de -1000 euros et le découvert autorisé pour un compte épargne est de 0 euros.");
	}

	
	
}
