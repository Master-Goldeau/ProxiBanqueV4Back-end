package org.proxibanqueV4.spring.exception;

/**
 * Exception AuditException
 * 
 * Une exception AuditException est générée lorsqu'un compte n'appartient pas à
 * un particulier ou à une entreprise.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 */
public class AuditException extends Exception {

	private static final long serialVersionUID = 1L;

	public AuditException() {
		super("Le compte ne peut pas être autre qu'un compte pour un particulier ou une entreprise.");
	}

}