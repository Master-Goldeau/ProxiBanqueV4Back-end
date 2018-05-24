package org.proxibanqueV4.spring.exception;

/**
 * Exception AuditException
 * 
 * Une exception AuditException est g�n�r�e lorsqu'un compte n'appartient pas �
 * un particulier ou � une entreprise.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 */
public class AuditException extends Exception {

	private static final long serialVersionUID = 1L;

	public AuditException() {
		super("Le compte ne peut pas �tre autre qu'un compte pour un particulier ou une entreprise.");
	}

}