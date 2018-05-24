package org.proxibanqueV4.spring.exception;

/**
 * Exception DecouvertException
 * 
 * Une exception DecouvertException est g�n�r�e lorsqu'une op�ration bancaire
 * met le solde du compte en-dessous du d�couvert autoris� (-1000 pour
 * CompteCourant, 0 pour CompteEpargne)
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 */
public class DecouvertException extends Exception {

	private static final long serialVersionUID = 1L;

	public DecouvertException() {
		super("Aucun virement possible en dessous du d�couvert autoris�. Le d�couvert autoris� pour un compte courant est de -1000 euros et le d�couvert autoris� pour un compte �pargne est de 0 euros.");
	}

}
