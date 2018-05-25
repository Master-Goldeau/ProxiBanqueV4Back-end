package org.proxibanqueV4.spring.service;

import java.util.List;

import org.proxibanqueV4.spring.model.Client;
import org.proxibanqueV4.spring.model.Compte;

/**
 * Interface regroupant les op�rations faites par le conseiller sur les comptes
 * d'un client Proxibanque(CRUD). Une subtilit� se trouve au niveau de la
 * m�thode associatedAddCompteE permettant de cr�er un compte �pargne et de
 * l'ajouter au client lors de sa cr�ation. Elle poss�de �galement l'op�ration :
 * r�cup�rer la liste des comptes d'un client.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 *
 */
public interface IProxiBanqueServiceCompte {

	/**
	 * Cr�er un compte �pargne et l'ajouter au client lors de sa cr�ation.
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
	 * Mettre-�-jour un compte.
	 * 
	 * @param c
	 */
	public void updateCompte(Compte c);

	/**
	 * R�cup�rer un compte via son id.
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
