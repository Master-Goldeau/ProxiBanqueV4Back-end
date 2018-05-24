package org.proxibanqueV4.spring.service;

import java.util.List;

import org.proxibanqueV4.spring.exception.AuditException;
import org.proxibanqueV4.spring.exception.DecouvertException;
import org.proxibanqueV4.spring.model.Compte;

/**
 * Interface regroupant les op�rations bancaires effectu�es par un conseiller
 * sur sa liste de comptes. Il y a deux op�rations bancaires impl�ment�es :
 * Audit et Virement.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 *
 */
public interface InterfaceVirAudService {

	/**
	 * Effectuer un virement Compte � Compte.
	 * 
	 * @param numCompteCrediteur
	 * @param numCompteDebiteur
	 * @param montant
	 * @throws DecouvertException
	 **/
	public void virement(long numCompteCrediteur, long numCompteDebiteur, double montant) throws DecouvertException;

	/**
	 * Effectuer l'audit des comptes.
	 * 
	 * @return List<Compte>
	 * @throws AuditException
	 */
	public List<Compte> audit() throws AuditException;

}
