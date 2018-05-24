package org.proxibanqueV4.spring.service;

import java.util.List;

import org.proxibanqueV4.spring.exception.AuditException;
import org.proxibanqueV4.spring.exception.DecouvertException;
import org.proxibanqueV4.spring.model.Compte;

public interface InterfaceVirAudService {

	public void virement(long numCompteCrediteur, long numCompteDebiteur, double montant) throws DecouvertException;

	public List<Compte> audit() throws AuditException;
	
//	public void Simulation(long numCompte);
}
