package org.proxibanqueV4.spring.exception;
public class AuditException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public AuditException() {
		super("Le compte ne peut pas être autre qu'un compte pour un particulier ou une entreprise.");
	}

	
	
}