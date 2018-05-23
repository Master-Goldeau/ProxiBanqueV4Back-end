package org.proxibanqueV4.spring.exception;

public class DecouvertException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public DecouvertException() {
		super("Aucun virement possible en dessous du d�couvert autoris�. Le d�couvert autoris� pour un compte courant est de -1000 euros et le d�couvert autoris� pour un compte �pargne est de 0 euros.");
	}

	
	
}
