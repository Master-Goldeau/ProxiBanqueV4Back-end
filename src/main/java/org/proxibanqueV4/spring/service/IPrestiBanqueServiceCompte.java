package org.proxibanqueV4.spring.service;

import org.proxibanqueV4.spring.model.Client;
import org.proxibanqueV4.spring.model.Compte;

public interface IPrestiBanqueServiceCompte {

	public void AssociatedAddCompteE(Client client);
	
	public Compte editCompte(long numcompte);
	
	public void deleteCompte(long numcompte);

	public void updateCompte(Compte c);

	
}
