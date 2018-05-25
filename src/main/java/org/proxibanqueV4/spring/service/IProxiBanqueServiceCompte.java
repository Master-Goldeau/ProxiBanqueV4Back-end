package org.proxibanqueV4.spring.service;

import java.util.List;

import org.proxibanqueV4.spring.model.Client;
import org.proxibanqueV4.spring.model.Compte;

/**
 * Interface regroupant les opérations faites par le conseiller sur les comptes
 * d'un client Proxibanque(CRUD). Une subtilité se trouve au niveau de la
 * méthode associatedAddCompteE permettant de créer un compte épargne et de
 * l'ajouter au client lors de sa création. Elle possède également l'opération :
 * récupérer la liste des comptes d'un client.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 *
 */
public interface IProxiBanqueServiceCompte {

	/**
	 * Créer un compte épargne et l'ajouter au client lors de sa création.
	 * 
	 * @param client
	 */
	public void associatedAddCompteE(Client client);

	/**
	 * Supprimer un compte via son id.
	 * 
	 * @param numcompte
	 */
	public void deleteCompte(long numcompte);

	/**
	 * Mettre-à-jour un compte.
	 * 
	 * @param c
	 */
	public void updateCompte(Compte c);

	/**
	 * Récupérer un compte via son id.
	 * 
	 * @param numCompte
	 * @return Compte
	 */
	public Compte editCompte(long numCompte);


	/**
	 * Lister les comptes d'un client via l'id du client.
	 * 
	 * @param idClient
	 * @return List<Compte>
	 */
	public List<Compte> listComptesUnClient(long idClient);


}
