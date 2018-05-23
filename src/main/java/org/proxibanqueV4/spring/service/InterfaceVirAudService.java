package org.proxibanqueV4.spring.service;

import org.proxibanqueV4.spring.exception.DecouvertException;

public interface InterfaceVirAudService {

	public void Virement(long numCompteCrediteur, long numCompteDebiteur, double montant) throws DecouvertException;

	public void Audit(long numCompte);
}
