package org.proxibanqueV4.spring.exception;

/**
 * Exception DecouvertException
 * 
 * Une exception DecouvertException est générée lorsqu'une opération bancaire
 * met le solde du compte en-dessous du découvert autorisé (-1000 pour
 * CompteCourant, 0 pour CompteEpargne)
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 */
public class DecouvertException extends Exception {

	private static final long serialVersionUID = 1L;

	public DecouvertException() {
		super("Aucun virement possible en dessous du découvert autorisé. Le découvert autorisé pour un compte courant est de -1000 euros et le découvert autorisé pour un compte épargne est de 0 euros.");
	}

}
