package org.proxibanqueV4.spring.service;

import org.proxibanqueV4.spring.exception.AuditException;
import org.proxibanqueV4.spring.exception.DecouvertException;

public interface InterfaceVirAudService {

	public void virement(long numCompteCrediteur, long numCompteDebiteur, double montant) throws DecouvertException;

	public Boolean audit(long numCompte) throws AuditException;
	
//	public void Simulation(long numCompte);
}
