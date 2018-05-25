package org.proxibanqueV4.spring.service;

import java.util.List;

import org.proxibanqueV4.spring.model.Client;
import org.proxibanqueV4.spring.model.Compte;

public interface IPrestiBanqueServiceCompte {

	public void AssociatedAddCompteE(Client client);
	
	public void deleteCompte(long numcompte);

	public void updateCompte(Compte c);
	
	public Compte editCompte(long numCompte);


//	public List<Compte> listComptesUnClient(long idClient);

	
}
