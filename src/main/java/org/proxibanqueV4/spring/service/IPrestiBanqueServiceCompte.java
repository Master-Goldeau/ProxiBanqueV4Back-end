package org.proxibanqueV4.spring.service;

import java.util.List;

import org.proxibanqueV4.spring.model.Compte;

public interface IPrestiBanqueServiceCompte {
	public void addCompte(Compte c);

	public List<Compte> listComptes();

	public void deleteCompte(long numcompte);

	public Compte editCompte(long numcompte);

	public void updateCcompte(Compte c);

}
